package com.quercusdata.awsspringboot.entity;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public abstract class AbstractDomainObject implements Serializable
{
    private static final Logger	log					= LoggerFactory.getLogger(AbstractDomainObject.class);

    private static final long	serialVersionUID	= -7448872795888313759L;

    @Override
    public String toString()
    {
        log.debug("Entering");

        try
        {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e)
        {
            log.warn("Could not print JSON of the object: " + e.getMessage());
            e.printStackTrace();
            return super.toString();
        }
    }
}
