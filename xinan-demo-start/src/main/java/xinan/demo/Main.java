package xinan.demo;

/**
 * @description:
 * @author: xinan
 * @create: 2021-07-28 12:56
 **/
import io.swagger.models.auth.In;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;
import xinan.demo.baselearn.classloader.ClassloaderInterface;
import xinan.demo.baselearn.classloader.DProcessor;

import java.io.IOException;
import java.util.*;
public class Main {
    static List<ClassloaderInterface> list = new ArrayList<>();
    private static final String basePackage = "xinan.demo.baselearn.classloader";
    static {
        ClassLoader classLoader = Main.class.getClassLoader();
        Set<String> processorClasses = findCandidateComponents(basePackage, DProcessor.class,
                classLoader);
        for (String p : processorClasses) {
            ClassloaderInterface fn = null;
            try {
                Class<?> clz = Class.forName(p, true, classLoader);
                fn = (ClassloaderInterface)clz.newInstance();
            } catch (Exception e) {
                System.out.print("newInstance exception");
            }
            list.add(fn);
        }
        //Collections.sort(processors, (o1, o2) -> o1.priority() - o2.priority());
    }
    public static void main (String args[]) {
        for (ClassloaderInterface classloaderInterface : list) {
            classloaderInterface.print();
        }
    }

    public static Set<String> findCandidateComponents(String basePackages, Class annotatedClz,
                                                      ClassLoader classLoader) {
        ResourcePatternResolver resolver = classLoader == null ?
                new PathMatchingResourcePatternResolver() : new PathMatchingResourcePatternResolver(classLoader);
        MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resolver);
        Set<String> candidates = new LinkedHashSet<>();
        try {
            for (String basePackage : basePackages.split(",")) {
                String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
                        + ClassUtils.convertClassNameToResourcePath(basePackage) + "/"
                        + "**/*.class";
                Resource[] resources = resolver.getResources(packageSearchPath);
                for (Resource resource : resources) {
                    if (resource.isReadable()) {
                        try {
                            MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(resource);
                            AnnotationMetadata metadata = metadataReader.getAnnotationMetadata();
                            if (metadata.isAnnotated(annotatedClz.getName())
                                    && metadataReader.getClassMetadata().isConcrete()) {
                                candidates.add(metadataReader.getClassMetadata().getClassName());
                            }
                        } catch (Throwable ex) {
                            throw new BeanDefinitionStoreException(
                                    "Failed to read candidate class: " + annotatedClz.getName() + ":" + resource, ex);
                        }
                    }
                }
            }
        } catch (IOException ex) {
            throw new BeanDefinitionStoreException("I/O failure during classpath scanning", ex);
        }
        return candidates;
    }
}
