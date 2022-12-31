package com.mehdilagdimi.marocair_api.dao;

import com.mehdilagdimi.marocair_api.base.TransactionExecuterFI;
import com.mehdilagdimi.marocair_api.base.TransactionGetExecuterFI;
import com.mehdilagdimi.marocair_api.util.HibernateUtil.TransactionExecuter;

import jakarta.enterprise.context.Dependent;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

@Dependent
public class DaoExecuter<T> extends TransactionExecuter implements Serializable {
    private Class<? extends T> type;
    String typeStr;
    String paramTypeStr;
    TransactionExecuterFI<Session> expression;
    TransactionGetExecuterFI<Session, T> getExpression;


    TransactionGetExecuterFI<Session, List<T>> getListExpression;
    TransactionGetExecuterFI<Session, T> getCountExpression;
    public DaoExecuter() {

    }
    public DaoExecuter(Class<T> beanImpl){
        type = beanImpl;
        typeStr = type.getSimpleName();
    }
    public void setType(Class<? extends T> type) {
        this.type = type;
        this.typeStr = this.type.getSimpleName();
    }


    public List<T> customSelectQuery(TransactionGetExecuterFI<Session, List<T>> getListExpressionParam){
        return (List<T>) executeTransaction(getListExpressionParam);
    }

    public T get(int id, Class<? extends T> type){
        getExpression = (s -> s.get(type, id));
        return (T) executeTransaction(getExpression);
    }

    public T find(int id, Class<? extends T> type){
        getExpression = (s -> s.find(type, id));
        return (T) executeTransaction(getExpression);
    }

    public List<T> getAll(Class<? extends T> type){
        getListExpression = (s -> (List<T>) s.createQuery("SELECT m FROM "+ type.getSimpleName() +" m", type).getResultList());
        return (List<T>) executeTransaction(getListExpression);
    }

    public void save(T jpaBean){
        expression = (s -> s.persist(jpaBean));
        executeTransaction(expression);
    }

    public void update(T jpaBean){
        expression = (s -> s.merge(jpaBean));
        executeTransaction(expression);
    }

    public void delete(T jpaBean){
        expression = (s -> s.remove(jpaBean));
        executeTransaction(expression);
    }

    public long count(){
        getCountExpression = (s -> (T) s.createQuery("SELECT COUNT(*) FROM "+ typeStr +" m", type).uniqueResult());
        return  (long)executeTransaction(getCountExpression);
    }

    public long namedQueryCount(String namedQuery, String param, String value){
        getCountExpression = (s-> (T) s.createNamedQuery(namedQuery, type).setParameter(param, value).uniqueResult());
        return (long) executeTransaction(getCountExpression);
    }

}
