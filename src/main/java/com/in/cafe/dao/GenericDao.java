package com.in.cafe.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.in.cafe.utils.PageDetails;



public interface GenericDao {
//	List<Object[]> createQuery(String query, Map<String, Object> var);

    List<Object[]> createSQLQuery(String query, Map<String, Object> var);

//    Object createSingleSQLQuery(String query, Map<String, Object> var);
//
//    List<Object[]> createByCountQuery(String query, Map<String, Object> var, int firstResult, int maxResult);
//
//    long countForQuery(String from, String countOn, String where, Map<String, Object> var);
//
//    Object singleColObject(String query, Map<String, Object> var);
//
//    int updateDeleteQuery(String query, Map<String, Object> var);
//
//
//
//    List<Object[]> createNativeQueryForReporting(String searchQuery, Map<String, Object> var, PageDetails pageDetails);
//
//    List<Object[]> callStoredProcedure(String spName, Map<String, Object> attributesMap);
//
//    public List<LinkedHashMap<String, Object>> callStoredProcedureMap(String spName, Map<String, Object> attributesMap);
//    
//    public int updateDeleteSQLQuery(String query, Map<String, Object> var);
}
