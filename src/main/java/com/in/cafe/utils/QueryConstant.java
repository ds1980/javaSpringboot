package com.in.cafe.utils;

public class QueryConstant {
	 public static String getFieldQueryBySubModuleId(){
	        StringBuilder sb = new StringBuilder();
	        sb.append("select tc.label_name  as c0 , ");
	        sb.append("tc.default_value  as c1, ");
	        sb.append("tc.field_info  as c2, ");
	        sb.append("tc.is_show  as c3, ");
	        sb.append("tc.drop_down  as c4, ");
	        sb.append("tc.is_corrigendum  as c5, ");
	        sb.append("tf.field_name  as c6, ");
	        sb.append("tf.field_type  as c7, ");
	        sb.append("ts.section_name  as c8 , ts.section_id as c9 ,");
	        sb.append("tf.is_mandatory as c10 ");
	        sb.append("from tbl_customeparameter tc ");
	        sb.append("inner join tbl_field tf on tf.field_id  =tc.field_id  and tc.client_id =:clientId ");
	        sb.append("inner join tbl_section ts on ts.section_id  = tf.section_id ");
	        sb.append("where tc.client_id  = :clientId and tc.sub_module_id = :subModuleId  and ");
	        sb.append("tf.section_id =:sectionId order by tc.sort_order asc");
	        return  sb.toString();
	    }

	    public static  String getStatusQuery(){
	       return new String("select st.status_name  as c0 , tsv.status_id as c1 , tsv.status_name  as c2 , tsv.status_icon as c3 ,tsv.is_default  as c4 from tbl_status_value tsv inner join tbl_status st on st.status = tsv.status where st.status_name  in(:statusString) ");
	    }
}
