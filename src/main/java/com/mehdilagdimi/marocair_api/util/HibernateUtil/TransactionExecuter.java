package com.mehdilagdimi.marocair_api.util.HibernateUtil;



import com.mehdilagdimi.marocair_api.base.TransactionExecuterFI;
import com.mehdilagdimi.marocair_api.base.TransactionGetExecuterFI;
import org.hibernate.Transaction;

public abstract class TransactionExecuter<T> {

    public void executeTransaction(TransactionExecuterFI transactionExpression){
        Transaction transaction = null;
        try{
            transaction = HibernateUtil.getSession().getTransaction();

            transaction.begin();
            transactionExpression.accept(HibernateUtil.getSession());
            transaction.commit();

        } catch (RuntimeException e){
            e.printStackTrace();
        } finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
//            HibernateUtil.closeSession();
        }
    }
    public T executeTransaction(TransactionGetExecuterFI transactionGetExpression){
        Transaction transaction = null;
        T obj = null;
        try{
            transaction = HibernateUtil.getSession().getTransaction();

            transaction.begin();
            obj = (T) transactionGetExpression.accept(HibernateUtil.getSession());
            transaction.commit();

        } catch (RuntimeException e){
            e.printStackTrace();
        } finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
//            HibernateUtil.closeSession();
        }
        return obj;
    }

}
