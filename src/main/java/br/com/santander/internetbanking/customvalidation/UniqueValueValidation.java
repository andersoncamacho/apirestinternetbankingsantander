package br.com.santander.internetbanking.customvalidation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.Assert;

import java.util.List;

public class UniqueValueValidation implements ConstraintValidator<UniqueValue, Object> {

    private Class<?> klass;
    private String domainAttribute;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(UniqueValue params) {
        klass = params.domainClass();
        domainAttribute = params.fieldName();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        if(value == null) {
            return true;
        }

        Query query = manager.createQuery(" select 1 from "+klass.getName()+" where "+domainAttribute+"=:value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();

        Assert.state(list.size() <= 1, "Foi encontrado mais de um "+klass+" com o atrinuto "+domainAttribute+ " = "+value);

        return list.isEmpty();
    }
}
