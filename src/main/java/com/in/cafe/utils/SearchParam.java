package com.in.cafe.utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SearchParam {
	 private String key;
	    private Object value;

	    private Operation_enum operation;

	    public Operation_enum getOperation() {
	        return operation;
	    }

	    public void setOperation(Operation_enum operation) {
	        this.operation = operation;
	    }

	    public String getKey() {
	        return key;
	    }

	    public void setKey(String key) {
	        this.key = key;
	    }


	    public Object getValue() {
	        return value;
	    }

	    public void setValue(Object value) {
	        this.value = value;
	    }

	    /**
	     * Gets the map.
	     *
	     * @param list        the list
	     * @param searchParam the search param
	     * @return the map
	     */
	    public static Map<String, Object> getMap(List<SearchParam> list, Map<String, String> searchParam) {
	        Map<String, Object> map = new HashMap<>();
	        list.forEach(e -> map.put(searchParam.get(e.getKey()), e.getValue()));
	        return map;
	    }

	    /**
	     * Builds the page in map.
	     *
	     * @param stringBuilder the string builder
	     * @param pageDetail    the page detail
	     * @param collect       the collect
	     * @return the map
	     */
	    public static Map<String, Object> buildPageInMap(PageDetails pageDetail,
	                                                     Map<String, String> collect) {
	        Map<String, Object> map = buildPageInMapWithOutFilter(pageDetail);
	        List<SearchParam> searchParams = pageDetail.getJsonArr();
	        if (searchParams != null && !searchParams.isEmpty()) {
	            Map<String, Object> map1 = SearchParam.getMap(searchParams, collect);
	            map.putAll(map1);
	        } else {
	            Map<String, Object> map1 = SearchParam.getDefaultMap(collect);
	            map.putAll(map1);
	        }
	        return map;
	    }

	    /**
	     * Builds the page in map with out filter.
	     *
	     * @param pageDetail    the page detail
	     * @return the map
	     */
	    public static Map<String, Object> buildPageInMapWithOutFilter(PageDetails pageDetail) {
	        Map<String, Object> map = new LinkedHashMap<>();
	        map.put("IN_PAGE_INDEX", pageDetail.getPageIndex());
	        map.put("in_page_size", pageDetail.getPageElement());
	        return map;
	    }

	    public static Map<String, Object> getDefaultMap(Map<String, String> defaultmap) {
	        Map<String, Object> map = new HashMap<>();
	        defaultmap.forEach((k, v) -> map.put(k, 0));
	        return map;
	    }
}
