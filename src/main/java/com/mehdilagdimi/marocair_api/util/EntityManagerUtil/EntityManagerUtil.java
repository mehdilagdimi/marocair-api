package com.mehdilagdimi.marocair_api.util.EntityManagerUtil;//package com.marjanefranchise.marjane_franchise_promotion_manager.util.HibernateUtil;
//
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.spi.PersistenceUnitInfo;
//import jakarta.persistence.spi.PersistenceUnitTransactionType;
//import org.hibernate.jpa.HibernatePersistenceProvider;
//import org.postgresql.ds.PGSimpleDataSource;
//
//import javax.sql.DataSource;
//import java.util.Collections;
//import java.util.List;
//import java.util.Properties;
//
//public class EntityManagerUtil {
//
//    public static DataSource dataSource() {
//        final PGSimpleDataSource dataSource = new PGSimpleDataSource();
//
//        dataSource.setDatabaseName( Config.getDBNAME() );
//        dataSource.setUser( Config.getUSER() );
//        dataSource.setPassword(Config.getPASSWORD());
//
//        return dataSource;
//    }
//
//    public static EntityManagerFactory entityManagerFactory(DataSource dataSource, Properties hibernateProperties ){
//        HibernatePersistenceProvider hibernatePersistenceProvider = new HibernatePersistenceProvider();
//
//        EntityManagerFactory entityManagerFactory = hibernatePersistenceProvider
//                .createContainerEntityManagerFactory(persistenceUnitInfo, Collections.EMPTY_MAP);
//
//        return entityManagerFactory.createEntityManager();
//    }
//
//    private static PersistenceUnitInfo archiverPersistenceUnitInfo() {
//        return new PersistenceUnitInfo() {
//            @Override
//            public String getPersistenceUnitName() {
//                return "ApplicationPersistenceUnit";
//            }
//
//            @Override
//            public String getPersistenceProviderClassName() {
//                return "org.hibernate.jpa.HibernatePersistenceProvider";
//            }
//
//            @Override
//            public PersistenceUnitTransactionType getTransactionType() {
//                return PersistenceUnitTransactionType.RESOURCE_LOCAL;
//            }
//
//            @Override
//            public DataSource getJtaDataSource() {
//                return null;
//            }
//
//            @Override
//            public DataSource getNonJtaDataSource() {
//                return null;
//            }
//
//            @Override
//            public List<String> getMappingFileNames() {
//                return Collections.emptyList();
//            }
//
//            @Override
//            public List<URL> getJarFileUrls() {
//                try {
//                    return Collections.list(this.getClass()
//                            .getClassLoader()
//                            .getResources(""));
//                } catch (IOException e) {
//                    throw new UncheckedIOException(e);
//                }
//            }
//
//            @Override
//            public URL getPersistenceUnitRootUrl() {
//                return null;
//            }
//
//            @Override
//            public List<String> getManagedClassNames() {
//                return Collections.emptyList();
//            }
//
//            @Override
//            public boolean excludeUnlistedClasses() {
//                return false;
//            }
//
//            @Override
//            public SharedCacheMode getSharedCacheMode() {
//                return null;
//            }
//
//            @Override
//            public ValidationMode getValidationMode() {
//                return null;
//            }
//
//            @Override
//            public Properties getProperties() {
//                return new Properties();
//            }
//
//            @Override
//            public String getPersistenceXMLSchemaVersion() {
//                return null;
//            }
//
//            @Override
//            public ClassLoader getClassLoader() {
//                return null;
//            }
//
//            @Override
//            public void addTransformer(ClassTransformer transformer) {
//
//            }
//
//            @Override
//            public ClassLoader getNewTempClassLoader() {
//                return null;
//            }
//        };
//    }
//}
