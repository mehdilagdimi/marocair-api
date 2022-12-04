package com.mehdilagdimi.marocair_api.util.EntityManagerUtil;//package com.marjanefranchise.marjane_franchise_promotion_manager.util.EntityManagerUtil;
//
//import com.marjanefranchise.marjane_franchise_promotion_manager.base.BeanLambdaSetters;
//import com.marjanefranchise.marjane_franchise_promotion_manager.base.BeanSetterFI;
//import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Center;
//import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Manager;
//
//import java.util.*;
//
//public abstract class ManagerLambdaSetters implements BeanLambdaSetters {
//
//    private static List<BeanSetterFI> managerSettersAsLambdas;
//    private static Manager manager;
//    private static BeanSetterFI<String> beanSetFullName;
//    private static BeanSetterFI<String> beanSetEmail;
//    private static BeanSetterFI<String> beanSetPassword ;
//    private static BeanSetterFI<Center> beanSetCenter;
//    private static Map<String,  List<BeanSetterFI>> allBeansSettersAsLambda;
//
//
//    public static void setAllBeansSettersAsLambda (){
//        allBeansSettersAsLambda = new HashMap<>(Map.ofEntries(
//                Map.entry("Manager", managerSettersAsLambdas)
//        ));
//    }
//    
//    public static List<BeanSetterFI> getBeanLambdaSetters(String bean){
//            return allBeansSettersAsLambda.get(bean);
//    }
//    
//    public static void setManagerReference (Manager managerRef){
//        manager = managerRef;
//        updateManagerRef();
//    }
//    public static void updateManagerRef(){
//        beanSetFullName = manager::setFullname;
//        beanSetEmail = manager::setEmail;
//        beanSetPassword = manager::setPassw;
//        beanSetCenter = manager::setCenter;
//
//        managerSettersAsLambdas = new ArrayList<>(Arrays.asList(
//                beanSetFullName,
//                beanSetEmail,
//                beanSetPassword,
//                beanSetCenter
//        ));
//
//        //always reupdate new references t
//        setAllBeansSettersAsLambda();
//    }
//}
