//package xinan.demo;
//
//import org.apache.hadoop.conf.Configuration;
//import org.apache.hadoop.hbase.*;
//import org.apache.hadoop.hbase.client.*;
//import org.apache.hadoop.hbase.io.compress.Compression;
//import org.apache.hadoop.hbase.util.Bytes;
//
//import java.io.IOException;
//
//import static org.apache.hadoop.hbase.mapreduce.Import.TABLE_NAME;
//
//public class ExampleForHBase {
//    private static final String CF_NAME = "info";
//    public static Configuration configuration;
//    public static Connection connection;
//    public static Admin admin;
//    public static void main(String[] args) throws Exception {
//        init();
//        createTable(connection);
//        insertData("student","zhangsan","info","English","69");
//        insertData("student","zhangsan","info","Math","86");
//        insertData("student","zhangsan","info","Computer","77");
//        getData("student", "zhangsan", "info","English");
//        close();
//    }
//
//    public static void init(){
//        configuration  = HBaseConfiguration.create();
//        configuration.set("hbase.rootdir","hdfs://localhost:9000/hbase");
//        try{
//            connection = ConnectionFactory.createConnection(configuration);
//            admin = connection.getAdmin();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//
//    public static void close(){
//        try{
//            if(admin != null){
//                admin.close();
//            }
//            if(null != connection){
//                connection.close();
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//
////    public static void createTable(String myTableName,String[] colFamily) throws IOException {
////        TableName tableName = TableName.valueOf(myTableName);
////        if(admin.tableExists(tableName)){
////            System.out.println("talbe is exists!");
////        }else {
////            TableDescriptorBuilder tableDescriptor = TableDescriptorBuilder.newBuilder(tableName);
////            for(String str:colFamily){
////                ColumnFamilyDescriptor family =
////ColumnFamilyDescriptorBuilder.newBuilder(Bytes.toBytes(str)).build();
////                tableDescriptor.setColumnFamily(family);
////            }
////            admin.createTable(tableDescriptor.build());
////        }
////    }
//    private static void createTable(Connection connection) throws Exception {
//        System.out.println("start create table");
//        HTableDescriptor table = new HTableDescriptor(TableName.valueOf(TABLE_NAME));
//        table.addFamily(new HColumnDescriptor(CF_NAME).setCompressionType(Compression.Algorithm.NONE));
//        Admin admin = connection.getAdmin();
//        if (admin.tableExists(table.getTableName())) {
//            admin.disableTable(table.getTableName());
//            admin.deleteTable(table.getTableName());
//        }
//        admin.createTable(table);
//        System.out.println("end create table");
//    }
//
//    public static void insertData(String tableName,String rowKey,String colFamily,String col,String val) throws IOException {
//        Table table = connection.getTable(TableName.valueOf(tableName));
//        Put put = new Put(rowKey.getBytes());
//        put.addColumn(colFamily.getBytes(),col.getBytes(), val.getBytes());
//        table.put(put);
//        table.close();
//    }
//
//    public static void getData(String tableName,String rowKey,String colFamily, String col)throws  IOException{
//        Table table = connection.getTable(TableName.valueOf(tableName));
//        Get get = new Get(rowKey.getBytes());
//        get.addColumn(colFamily.getBytes(),col.getBytes());
//        Result result = table.get(get);
//        System.out.println(new String(result.getValue(colFamily.getBytes(),col==null?null:col.getBytes())));
//        table.close();
//    }
//}