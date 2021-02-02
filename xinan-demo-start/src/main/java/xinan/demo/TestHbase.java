package xinan.demo;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.io.compress.Compression;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class TestHbase {
    private static final String TABLE_NAME = "user";
    private static final String CF_NAME = "info";

    public static void main(String[] args) throws Exception {
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.rootdir","hdfs://localhost:9000/hbase");
        Connection connection = ConnectionFactory.createConnection(config);
        // 创建表
        createTable(connection);
        // 插入一条数据
        insertData(connection);
        // 批量插入数据
        batchInsertData(connection);
        // 查询所有数据
        selectAll(connection);
        // 查询一条数据(rowkey)
        selectOne(connection);

    }

    private static void createTable(Connection connection) throws Exception {
        System.out.println("start create table");
        HTableDescriptor table = new HTableDescriptor(TableName.valueOf(TABLE_NAME));
        table.addFamily(new HColumnDescriptor(CF_NAME).setCompressionType(Compression.Algorithm.NONE));
        Admin admin = connection.getAdmin();
        if (admin.tableExists(table.getTableName())) {
            admin.disableTable(table.getTableName());
            admin.deleteTable(table.getTableName());
        }
        admin.createTable(table);
        System.out.println("end create table");
    }

    private static void insertData(Connection connection) throws Exception {
        System.out.println("start insert");
        Table table = connection.getTable(TableName.valueOf(TABLE_NAME));
        Put put = new Put(Bytes.toBytes("rk001"));
        put.addColumn(Bytes.toBytes(CF_NAME), Bytes.toBytes("age"), Bytes.toBytes(1));
        table.put(put);
        System.out.println("end insert");
    }

    private static void batchInsertData(Connection connection) throws Exception {
        System.out.println("start batchInsertData");
        List<Put> puts = new ArrayList<>();
        Table table = connection.getTable(TableName.valueOf(TABLE_NAME));
        for (int i = 2; i < 100; i++) {
            Put put = new Put(Bytes.toBytes("rk00" + i));
            put.addColumn(Bytes.toBytes(CF_NAME), Bytes.toBytes("age"), Bytes.toBytes(i));
            puts.add(put);
        }
        table.put(puts);
        System.out.println("end batchInsertData");
    }

    private static void selectAll(Connection connection) throws Exception {
        System.out.println("start selectAll");
        Table table = connection.getTable(TableName.valueOf(TABLE_NAME));
        Scan scan = new Scan();
        ResultScanner resultScanner = table.getScanner(scan);
        List<Map<String, Object>> dataList = new ArrayList<>();
        for (Result result : resultScanner) {
            List<Cell> cellList = result.listCells();
            for (Cell cell : cellList) {
                Map<String, Object> data = new HashMap<>();
                // 取行健
                data.put("rowKey", Bytes.toString(CellUtil.cloneRow(cell)));
                // 取时间戳
                data.put("timestamp", cell.getTimestamp());
                // 取列簇
                data.put("family", Bytes.toString(CellUtil.cloneFamily(cell)));
                // 取列
                data.put("qualifier", Bytes.toString(CellUtil.cloneQualifier(cell)));
                // 取值
                data.put("value", Bytes.toInt(CellUtil.cloneValue(cell)));
                dataList.add(data);
            }
        }
        System.out.println(dataList);
        System.out.println("end selectAll");
    }

    private static void selectOne(Connection connection) throws Exception {
        System.out.println("start selectOne");
        List<Map<String, Object>> dataList = new ArrayList<>();
        Table table = connection.getTable(TableName.valueOf(TABLE_NAME));
        Get get = new Get(Bytes.toBytes("rk001"));
        Result result = table.get(get);
        List<Cell> cellList = result.listCells();
        for (Cell cell : cellList) {
            Map<String, Object> data = new HashMap<>();
            // 取行健
            data.put("rowKey", Bytes.toString(CellUtil.cloneRow(cell)));
            // 取时间戳
            data.put("timestamp", cell.getTimestamp());
            // 取列簇
            data.put("family", Bytes.toString(CellUtil.cloneFamily(cell)));
            // 取列
            data.put("qualifier", Bytes.toString(CellUtil.cloneQualifier(cell)));
            // 取值
            data.put("value", Bytes.toInt(CellUtil.cloneValue(cell)));
            dataList.add(data);
        }
        System.out.println(dataList);
        System.out.println("end selectOne");
    }

    public static List<Map<String,Object>> receiveCollectionList(List<Map<String,Object>> todayItemIdList, List<String> itemList) {
        List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
        for (Map<String,Object> map :todayItemIdList){
            for (String key : map.keySet()){
                if (itemList.contains(key)){
                    resultList.add(map);
                    break;
                }
            }
        }
        return resultList;

    }

    public static List<String> jiaoji(List<String>todayItemList,List<String>yesterdayItemList){
        List<String> itemList = todayItemList.stream().filter(item -> yesterdayItemList.contains(item)).collect(toList());
        return itemList;
    }

}