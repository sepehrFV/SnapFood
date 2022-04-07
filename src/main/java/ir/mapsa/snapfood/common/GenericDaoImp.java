package ir.mapsa.snapfood.common;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.webjars.NotFoundException;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class GenericDaoImp<E,ID extends Serializable> implements IGenericDao<E,ID>{

    //using java reflection to find entity class information
    private Class<E> classType;
    private String className;

    private Session session;

    public void setSession(Session session){
        this.session = session;
    }

    public GenericDaoImp(){

        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        classType = (Class<E>) pt.getActualTypeArguments()[0];
        String tmpName = classType.getName();
        this.className = tmpName.substring(tmpName.lastIndexOf('.')+1,tmpName.length());

    }

    @Override
    public void insert(E entity) {

        session.saveOrUpdate(entity);

    }

    @Override
    public E update(E updatedEntity) {

        session.update(updatedEntity);
        return updatedEntity;
    }

    @Override
    public void delete(ID id) {

       session.delete(findById(id));
    }

    //we need class type for this method
    @Override
    public E findById(ID id) {
      return session.get(classType,id);
    }

    //and also name for this part
    @Override
    public List<E> findAll() {
        List<E> resultList = null;
        Query query = session.createQuery("from "+ this.className).setCacheable(true);
        resultList = query.getResultList();
        return resultList;

    }

}
