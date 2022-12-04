package com.mehdilagdimi.marocair_api.controller;


import com.mehdilagdimi.marocair_api.base.BeanLambdaSetters;
import com.mehdilagdimi.marocair_api.base.TransactionGetExecuterFI;
import com.mehdilagdimi.marocair_api.base.getBeanSettersFI;
import com.mehdilagdimi.marocair_api.dao.DaoExecuter;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.Session;

import java.util.List;
import java.util.stream.IntStream;

public class BeanController {

    private static DaoExecuter daoExecuter = new DaoExecuter<>();


    public static<T, P> List<T> customSelectQuerySingleParam(Class<T> beanImpl, Class<P> paramImpl, String param, P value){
        TransactionGetExecuterFI<Session, List<T>> getListExpression;
        if(value instanceof Number){
            getListExpression  = s -> s.createQuery("SELECT b FROM " + beanImpl.getSimpleName() + " b WHERE " + "b." + param + "=" + value, beanImpl).getResultList();
        } else {
            getListExpression  = s -> s.createQuery("SELECT b FROM " + beanImpl.getSimpleName() + " b WHERE " + "b." + param + "='" + value + "'", beanImpl).getResultList();
        }
        return (List<T>) daoExecuter.customSelectQuery(getListExpression);
    }
    @SafeVarargs
    public static<T, P> List<T> customSelectQueryMultipleParams(Class<T> beanImpl, Class<P> paramImpl, String[] params, P... values ){
        daoExecuter.setType(beanImpl);
        TransactionGetExecuterFI<Session, List<T>> getListExpression  = s -> s.createQuery("SELECT b FROM " + beanImpl.getSimpleName() + " b WHERE " + "b." + params[0] + "='" + values[0] +"' AND b."+ params[1] + "='" + values[1] + "'", beanImpl).getResultList();

        return (List<T>) daoExecuter.customSelectQuery(getListExpression);
    }
    public static<T> T find(int id, Class<T> beanImpl){
        daoExecuter.setType(beanImpl);
        return (T) daoExecuter.find(id);
    }
    public static<T> List<T> getAll(Class<T> beanImpl){
        daoExecuter.setType(beanImpl);
        return (List<T>) daoExecuter.getAll();
    }


    //pass request and get params values to set them into bean
    public static<T extends getBeanSettersFI> T add(T bean, Class<T> beanImpl, HttpServletRequest request, String... params)  {
        daoExecuter.setType(beanImpl);

        IntStream.range(0, params.length).forEach( i -> {
            System.out.println(" req " + request.getAttribute(params[i]));
            BeanLambdaSetters.getBeanLambdaSetters(bean).get(params[i]).set(request.getAttribute(params[i]));
        });

        daoExecuter.save(bean);
        return bean;
    }

    public static<T extends getBeanSettersFI> void update(T bean, Class<T> beanImpl, HttpServletRequest request, String... params){
        daoExecuter.setType(beanImpl);

        IntStream.range(0, params.length).forEach(i -> {
            BeanLambdaSetters.getBeanLambdaSetters(bean).get(params[i]).set(request.getAttribute(params[i]));
        });

        daoExecuter.update(bean);
    }
    public static<T> void simpleUpdate(T bean, Class<T> beanImpl){
        daoExecuter.setType(beanImpl);
        daoExecuter.update(bean);
    }


    public static<T> void delete(T bean, Class<T> beanImpl){
        daoExecuter.setType(beanImpl);
        daoExecuter.save(bean);
    }
    public static<T> long count(Class<T> beanImpl){
        daoExecuter.setType(beanImpl);
        return daoExecuter.count();
    }
    public static<T> long namedQueryCount(Class<T> beanImpl, String namedQuery, String param, String value){
        daoExecuter.setType(beanImpl);
        return daoExecuter.namedQueryCount(namedQuery, param, value);
    }



}
