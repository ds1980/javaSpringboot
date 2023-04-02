package com.in.cafe.constants;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.in.cafe.domain.StatusDto;




public class CafeConstants {
	public static final String SOMETING_WENT_WRONG = "Something went wrong";
	public static final String INVALID_DATA = "Invalid Data";
	public static final String UNAUTHRIZED_ACCESS = "Unauthorized access";
	public static final String DATA_DOES_NOT_EXIST = "Data does not exist of this id";
	public static final String STORE_LOCATION = "D:\\JavaAPI\\pdf";
	 // Regex for acceptable logins
    public static final String LOGIN_REGEX = "^[_.@A-Za-z0-9-]*$";
    
    public static final String SYSTEM_ACCOUNT = "system";
    public static final String DEFAULT_LANGUAGE = "en";
    public static final String ANONYMOUS_USER = "anonymoususer";
    public static final String WINDOWS_FILE_PATH_LOC = "C:"+File.separator+"eSourcingDesk"+File.separator;
    public static final String LINUX_FILE_PATH_LOC = File.separator+"home"+File.separator+"eSourcingDesk"+File.separator;
    public static final String SEPRATOR = "\\";
    public static final String DOCUMENT_BRIEFCASE = "documentBriefcase";
    public static final String DOCUMENTS = "documents";
    public static final String PDF = "pdf";
	public static final List<Long> SUPER_ADMIN_ID_LIST = Arrays.asList(1L);
	
    public static final String PENDIND_NAME = "Pending";
    public static final int PENDING_ID = 0;

    public static final String APPROVE_NAME = "Approve";
    public static final int APPROVE_ID = 1;

    public static final String IN_ACTIVE_CLIENT_NAME = "In Active";
    public static final int IN_ACTIVE_CLIENT_ID = 2;

    public static final String ALL_CLIENT_NAME = "All";
    public static final int ALL_CLIENT_ID = -1;

    public static final String LIVE_NAME = "Live";
    public static final int LIVE_ID = 1;

    public static final String ARCHIVE_NAME = "Archive";
    public static final int ARCHIVE_ID = 3;

    public static final String AWARDED_NAME = "Awarded";
    public static final int AWARDED_ID = 4;

    public static final String CANCELLED_NAME = "Cancelled";
    public static final int CANCELLED_ID = 2;
    public static final Integer BID_ACCESS_OPEN = 1;
    public static final Integer BID_ACCESS_LIMITED = 2;
    public static final int SHOW_ALTER = 1; // show alert true
    public static final Byte YES = 1;
    public static final Byte NO = 0;
    public static final Byte IS_MANDATORY = 1;
    public static final String IS_MANDATORY_NAME = "Yes";
    public static final String IS_NON_MANDATORY_NAME = "No";
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final String COMPLETED = "Completed";
    public static final String IN_COMPLETE = "In Complete";
    public static final byte ZERO_BYTE = 0;
    public static final String SP_SEARCHOFFICER = "sp_searchofficer";
    public static final byte TENDER_EVALUATION_STATUS = 2;
    public static final Long LINK_NEGOTIATION = 100L;
    public static final Long ZERO_LONG = 0L;
    public static final Integer REJECT_NEGO_OFFICER = 2;
    public static final Integer ACCEPT_NEGO_OFFICER = 1;
    public static final Integer REJECT_NEGO_BIDDER = 2;
    public static final Integer SUBMIT_NEGO_BIDDER = 3;
    public static final Integer CANCEL_NEOG_OFFICER = 3;
    public static final int INVITED_NEGO_BIDDER = 2;
    public static final int CLOSE_NEGOTIATION = 3;
    public static final String CANCEL_NEGO_REMARKS = "system generated cancelled negotation";
    public static final int PUBLISH_CORRIGENDUM = 1;
    public static final Byte CORRIGENDUM_FORM_STATUS = 2;
    public static final Integer CORRIGENDUM_NEW_FORM_ADD_TYPE = 1;
    public static final String FORM_ID = "formId";
    public static final String FORM_NAME = "formName";
    public static final Integer CORRIGENDUM_NEW_FORM_CANCEL_TYPE = 2;

    private static final String ST_TECHNOCOMORCIAL_FORM = "Technocomarcial Form";
    public static final int PRICE_BID_FORM = 2;
    public static final String ST_PRICE_BID_FORM = "Price Bid";
    public static final String ST_TECHNICAL_FORM = "Technical Form";
    public static final int TECHNOCOMORCIAL_FORM = 3;
    public static final int TECHNICAL_FORM = 1;
    public static final String ST_YES = "Yes";
    public static final String ST_NO = "No";


    public static final byte GRAND_TOTAL = 1;
    public static final byte ITEM_WISE = 2;
    public static final byte LOT_WISE = 3;

    public static final Integer EVENT_WISE_MAP_BIDDER_TYPE = 1;
    public static final Integer ITEM_WISE_MAP_BIDDER_TYPE = 2;
    public static final Integer LOT_WISE_MAP_BIDDER_TYPE = 3;

    public static final Integer PRICE_BID = 1;
    public static final Integer TECHNICAL_BID = 2;

    public static final String DISCUSSION_TYPE_GENERAL ="General";
    public static final Integer DISCUSSION_TYPE_ID_GENERAL = 1;
    private static final String ALL_ENV = "Technical & Price Bid";


    public static List<StatusDto> getAuctionstatus() {
        List<StatusDto> lst = new ArrayList<>();
        StatusDto statusDto = new StatusDto();
        statusDto.setStatusId(PENDING_ID);
        statusDto.setStatusName(PENDIND_NAME);
        lst.add(statusDto);
        statusDto = new StatusDto();
        statusDto.setStatusId(LIVE_ID);
        statusDto.setStatusName(LIVE_NAME);
        lst.add(statusDto);
        statusDto = new StatusDto();
        statusDto.setStatusId(AWARDED_ID);
        statusDto.setStatusName(AWARDED_NAME);
        lst.add(statusDto);
        statusDto = new StatusDto();
        statusDto.setStatusId(CANCELLED_ID);
        statusDto.setStatusName(CANCELLED_NAME);
        lst.add(statusDto);
        statusDto = new StatusDto();
        statusDto.setStatusId(ARCHIVE_ID);
        statusDto.setStatusName(ARCHIVE_NAME);
        lst.add(statusDto);
        return lst;
    }

    public static List<StatusDto> getTenderStatus() {
        List<StatusDto> lst = new ArrayList<>();
        StatusDto statusDto = new StatusDto();
        statusDto.setStatusId(PENDING_ID);
        statusDto.setStatusName(PENDIND_NAME);
        lst.add(statusDto);
        statusDto = new StatusDto();
        statusDto.setStatusId(LIVE_ID);
        statusDto.setStatusName(LIVE_NAME);
        lst.add(statusDto);
        statusDto = new StatusDto();
        statusDto.setStatusId(AWARDED_ID);
        statusDto.setStatusName(AWARDED_NAME);
        lst.add(statusDto);
        statusDto = new StatusDto();
        statusDto.setStatusId(CANCELLED_ID);
        statusDto.setStatusName(CANCELLED_NAME);
        lst.add(statusDto);
        statusDto = new StatusDto();
        statusDto.setStatusId(ARCHIVE_ID);
        statusDto.setStatusName(ARCHIVE_NAME);
        lst.add(statusDto);
        return lst;
    }


    public static List<StatusDto> getCommontatus() {
        List<StatusDto> lst = new ArrayList<>();
        StatusDto statusDto = new StatusDto();
        statusDto.setStatusId(ALL_CLIENT_ID);
        statusDto.setStatusName(ALL_CLIENT_NAME);
        lst.add(statusDto);
        statusDto = new StatusDto();
        statusDto.setStatusId(ACTIVE_STATUS);
        statusDto.setStatusName(ST_ACTIVE_STATUS);
        statusDto.setIconName("done_outline");
        lst.add(statusDto);
        statusDto = new StatusDto();
        statusDto.setStatusId(IN_ACTIVE_STATUS);
        statusDto.setStatusName(ST_IN_ACTIVE_STATUS);
        statusDto.setIconName("update");
        lst.add(statusDto);
        return lst;
    }

    /**
     *
     */
    private CafeConstants() {
        super();
    }

    public static final int ACTIVE_STATUS = 1;
    public static final int IN_ACTIVE_STATUS = 0;
    public static final String ST_IN_ACTIVE_STATUS = "In Active";
    public static final String ST_ACTIVE_STATUS = "Active";
    public static final long DEFAULT_PARENT_DEPT = 0;
    public static final int OTP_LENGHT = 8;
    public static final int OTP_VALIDITY_MIN = 3;
    public static final int FAILED_PASSWORD_ATTEMPTS = 2;
    public static final String DRIVE_FOR_FILE_UPLOAD = "E:";
    public static final String SEPERATOR = "/";
    public static final String FOLDER_FOR_FILE_UPLOAD = "uploadFiles";
    public static final String CLIENT_LOGO = "clientLogo";
    public static final String SECURE_ALGO = "PBEWithMD5AndDES";
    public static final int IS_SHOW = 1;
    public static final int AUCTION_MODULE_ID = 1;
    public static final int TENDER_MODULE_ID = 2;

    public static final int RFQ_SUB_MODULE_ID = 7;
    public static final int RFP_SUB_MODULE_ID = 8;

    public static final int GRAND_TOTAL_AUCTION = 1;
    public static final int ITEM_WISE_AUCTION = 2;
    public static final int LOT_WISE_AUCTION = 3;

    public static final int APPLICABLE = 1;
    public static final int NOT_APPLICABLE = 0;
    public static final String ST_APPLICABLE = "Applicable";
    public static final String ST_NOT_APPLICABLE = "Not Applicable";

    public static List<StatusDto> getWorkFlowStatus() {

        List<StatusDto> lst = new ArrayList<>();
        StatusDto statusDto = new StatusDto();
        statusDto.setStatusId(APPLICABLE);
        statusDto.setStatusName(ST_APPLICABLE);
        lst.add(statusDto);
        statusDto = new StatusDto();
        statusDto.setStatusId(NOT_APPLICABLE);
        statusDto.setStatusName(ST_NOT_APPLICABLE);
        lst.add(statusDto);
        return lst;
    }


	public static final Long ITEM_NAME_COLUMN_TYPE_ID = 2L;


    public static List<StatusDto> getBiddingFormType(){
        List<StatusDto> lst = new ArrayList<>();
        StatusDto statusDto = new StatusDto();
        statusDto.setStatusId(PRICE_BID_FORM);
        statusDto.setStatusName(ST_PRICE_BID_FORM);
        lst.add(statusDto);
        statusDto = new StatusDto();
        statusDto.setStatusId(TECHNICAL_FORM);
        statusDto.setStatusName(ST_TECHNICAL_FORM);
        lst.add(statusDto);
        statusDto = new StatusDto();
        statusDto.setStatusId(TECHNOCOMORCIAL_FORM);
        statusDto.setStatusName(ST_TECHNOCOMORCIAL_FORM);
        lst.add(statusDto);
        return lst;

    }

    public static List<StatusDto> getYesAndNo() {
        List<StatusDto> lst = new ArrayList<>();
        StatusDto statusDto = new StatusDto();
        statusDto.setStatusId(YES);
        statusDto.setStatusName(ST_YES);
        lst.add(statusDto);
        statusDto = new StatusDto();
        statusDto.setStatusId(NO);
        statusDto.setStatusName(ST_NO);
        lst.add(statusDto);
        return lst;
    }

    public static List<StatusDto> getClientStatus() {
        List<StatusDto> lst = new ArrayList<>();
        StatusDto statusDto = new StatusDto();
        statusDto.setStatusId(PENDING_ID);
        statusDto.setStatusName(PENDIND_NAME);
        lst.add(statusDto);
        statusDto = new StatusDto();
        statusDto.setStatusId(APPROVE_ID);
        statusDto.setStatusName(APPROVE_NAME);
        lst.add(statusDto);
        statusDto = new StatusDto();
        statusDto.setStatusId(IN_ACTIVE_CLIENT_ID);
        statusDto.setStatusName(IN_ACTIVE_CLIENT_NAME);
        lst.add(statusDto);
        statusDto = new StatusDto();
        statusDto.setStatusId(ALL_CLIENT_ID);
        statusDto.setStatusName(ALL_CLIENT_NAME);
        lst.add(statusDto);
        return lst;
    }

    public static final Long SR_NO_COLUMN_TYPE = 1L;
    public static final Long ITEM_NAME_COLUMN_TYPE = 2L;
    public static final Long QUANTITY_COLUMN_TYPE = 3L;
    public static final Long UNIT_RATE_COLUMN_TYPE=	4L;
    public static final Long CATEGORY_COLUMN_TYPE = 5L;
    public static final Long ITEM_CODE_COLUMN_TYPE = 6L;
    public static final Long UOM_COLUMN_TYPE	= 7L;
    public static final Long ITEM_DESC_COLUMN_TYPE = 8L;
    public static final Long LOADING_FACTORE_COLUMN_TYPE=9L;
    public static final Long HSN_CODE_COLUMN_TYPE =10L;
    public static final Long SAC_CODE_COLUMN_TYPE =11L;
    public static final Long OTHER_COLUMN_TYPE =12L;
    public static final Long TOTAL_RATE_COLUMN_TYPE = 13L;
    public static final Long NET_PRICE_COLUMN_TYPE =14L;
    public static final Long CURRENCY_COLUMN_TYPE = 15L;
    public static final Long ENCRYPTION_COLUMN_TYPE	= 16L;
    public static final Long GST_COLUMN_TYPE = 17L;
    public static final Long GST_WITH_LOADING_COLUMN_TYPE = 18L;
    public static final Long IN_WORDS_COLUMN_TYPE = 19L;

    public static final Integer FILLED_BY_OFFICER = 1;
    public static final Integer FILLED_BY_BIDDER = 2;
    public static final Integer FILLED_BY_AUTO = 3;

    public static final Integer DATA_TYPE_SMALL_TEXT=1;
    public static final Integer DATA_TYPE_LONG_TEXT=2;
    public static final Integer DATA_TYPE_NO_WITHOUT_DECIMAL=3;
    public static final Integer DATA_TYPE_NO_WITH_DECIMAL=4;
    public static final Integer DATA_TYPE_ALL_NUMBER=5;
    public static final Integer DATA_TYPE_COMBO=6;
    public static final Integer DATA_TYPE_DATE_TIME=7;

    public static List<StatusDto> getAllNegotiationOn() {
        List<StatusDto> lst = new ArrayList<>();
        StatusDto statusDto = new StatusDto();
        statusDto.setStatusId(PRICE_BID_FORM);
        statusDto.setStatusName(ST_PRICE_BID_FORM);
        lst.add(statusDto);
        statusDto = new StatusDto();
        statusDto.setStatusId(TECHNICAL_FORM);
        statusDto.setStatusName(ST_TECHNICAL_FORM);
        lst.add(statusDto);
        statusDto = new StatusDto();
        statusDto.setStatusId(CafeConstants.ZERO);
        statusDto.setStatusName(ALL_ENV);
        lst.add(statusDto);
        return lst;
    }

    public static List<StatusDto> getTechnicalNegotiationOn() {
        List<StatusDto> lst = new ArrayList<>();
        StatusDto statusDto = new StatusDto();
        statusDto.setStatusId(TECHNICAL_FORM);
        statusDto.setStatusName(ST_TECHNICAL_FORM);
        lst.add(statusDto);
        return lst;
    }

    public static List<StatusDto> getPriceBidNegotiationOn() {
        List<StatusDto> lst = new ArrayList<>();
        StatusDto statusDto = new StatusDto();
        statusDto.setStatusId(PRICE_BID_FORM);
        statusDto.setStatusName(ST_PRICE_BID_FORM);
        lst.add(statusDto);
        return lst;
    }

    public static final int CORRIGENDUM_TYPE_1 = 1;
    public static final String CORRIGENDUM_TYPE_1_NAME = "Date Extension";

    public static final int CORRIGENDUM_TYPE_2 = 2;
    public static final String CORRIGENDUM_TYPE_2_NAME ="Others";

    public static final int CORRIGENDUM_TYPE_3 = 3;
    public static final String CORRIGENDUM_TYPE_3_NAME = "Bidding Form";
    public static final Integer DISCUSSION_SUB_MODULE_ID = Integer.valueOf("9");

    public static List<StatusDto> getCorrigendumType() {
        List<StatusDto> lst = new ArrayList<>();
        StatusDto statusDto = new StatusDto();
        statusDto.setStatusId(CORRIGENDUM_TYPE_1);
        statusDto.setStatusName(CORRIGENDUM_TYPE_1_NAME);
        lst.add(statusDto);
        statusDto = new StatusDto();
        statusDto.setStatusId(CORRIGENDUM_TYPE_2);
        statusDto.setStatusName(CORRIGENDUM_TYPE_2_NAME );
        lst.add(statusDto);
        statusDto = new StatusDto();
        statusDto.setStatusId(CORRIGENDUM_TYPE_3);
        statusDto.setStatusName(CORRIGENDUM_TYPE_3_NAME );
        lst.add(statusDto);
        return lst;
    }
    
	public static final int DOC_STATUS_PENDING = 0;
	public static final int DOC_STATUS_APPROVED = 1;
	public static final int DOC_STATUS_CANCELLED = 2;
	public static final int DEFAULT_AMT_DSP_IN = 1;
}
