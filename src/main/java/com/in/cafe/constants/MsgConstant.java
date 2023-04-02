package com.in.cafe.constants;
public class MsgConstant {
	public static final String RECORD_NOT_FOUND = MessageUtil.getMsg("RECORD_NOT_FOUND");
    public static final String DUPLICATE_ROWS_FOUND  =MessageUtil.getMsg("DUPLICATE_ROWS_FOUND");
    public static final String REFERENCE_NOT_EXISTS = MessageUtil.getMsg("REFERENCE_NOT_EXISTS");
    public static final String INVALID_JSON_FORMAT = MessageUtil.getMsg("INVALID_JSON_FORMAT");
    public static final String ERROR_WHILE_FATCHING = MessageUtil.getMsg("ERROR_WHILE_FATCHING");
    public static final String ERROR_WHILE_CREATE = MessageUtil.getMsg("ERROR_WHILE_CREATE");
    public static final String ERROR_WHILE_UPDATE = MessageUtil.getMsg("ERROR_WHILE_UPDATE");
    public static final String ERROR_WHILE_UPDATE_ACTIVESTATUS = MessageUtil.getMsg("ERROR_WHILE_UPDATE_ACTIVESTATUS");
    public static final String UNKNOWN_ERROR_OCCURED = MessageUtil.getMsg("UNKNOWN_ERROR_OCCURED");
    public static final String JSON_PARSING_ERROR = MessageUtil.getMsg("JSON_PARSING_ERROR");
    public static final String UNSUPPORTED_MEDIA_TYPE = MessageUtil.getMsg("UNSUPPORTED_MEDIA_TYPE");
    public static final String JSON_RESPONSE_ERROR = MessageUtil.getMsg("JSON_RESPONSE_ERROR");
    public static final String ERROR_WHILE_DELETE = MessageUtil.getMsg("ERROR_WHILE_DELETE");
    public static final String INVALID_URL_FOUND = MessageUtil.getMsg("INVALID_URL_FOUND");
    public static final String ERROR_WHILE_DOWNLOAD = MessageUtil.getMsg("ERROR_WHILE_DOWNLOAD");
    public static final String ERROR_WHILE_SAVEFILE = MessageUtil.getMsg("ERROR_WHILE_SAVEFILE");
    public static final String FILE_NOT_FOUND = MessageUtil.getMsg("FILE_NOT_FOUND");
    public static final String VALIDATIONS_FAILED = MessageUtil.getMsg("VALIDATIONS_FAILED");
    public static final String DOCUMENT_NOT_FOUND = MessageUtil.getMsg("DOCUMENT_NOT_FOUND");
    public static final String RECORD_ALREADY_EXISTS = MessageUtil.getMsg("RECORD_ALREADY_EXISTS");
    public static final String SESSION_TIMEOUT = MessageUtil.getMsg("SESSION_TIME_OUT");
    public static final String ENV_NOT_OPEN = MessageUtil.getMsg("ENV_NOT_OPEN");
    public static final String NEGOTIAION_DATE_LAPS = MessageUtil.getMsg("NEGO_DATE_LAPS");
    public static final String NEGOTATION_IS_CLOSE = MessageUtil.getMsg("NEGOTATION_IS_CLOSE");
    public static final String APP_MSG_CANCEL = MessageUtil.getMsg("MSG.CANCEL");
    public static final String ERROR_WHILE_SUBMIT_NEGO =  MessageUtil.getMsg("ERROR_WHILE_SUBMIT_NEGO");

    private MsgConstant() {
		throw new IllegalStateException("Utility class");
	}

	public static final String APP_MSG_FETCH_LIST = MessageUtil.getMsg("MSG.FETCH.LIST");
	public static final String APP_MSG_FETCH = MessageUtil.getMsg("MSG.FETCH");
	public static final String APP_MSG_CREATE = MessageUtil.getMsg("MSG.CREATE");
	public static final String APP_MSG_UPDATE = MessageUtil.getMsg("MSG.UPDATE");
	public static final String APP_MSG_DELETE = MessageUtil.getMsg("MSG.DELETE");
    public static final String APP_MSG_PUBLISH = MessageUtil.getMsg("PUBLISH");
    public static final String APP_MSG_DELETE_BID = MessageUtil.getMsg("MSG.BID_DELETE_SUCCESSFUL");
    public static final String APP_MSG_BID_WITHDRAW = MessageUtil.getMsg("MSG.BIDWRAWAL_SUCCESSFUL");
    public static final String APP_MSG_FINAL_SUBMISSION_DONE = MessageUtil.getMsg("MSG.FINAL_SUBMISSION_COMPLETED");
    public static final String APP_MSG_SUBMISSION_TIMEOVER = MessageUtil.getMsg("MSG.BID_SUBMISSION_TIME_OVER");

    public static final String MSG_SAVE_DISCUSSION = MessageUtil.getMsg("SAVE_DISCUSION");
    public static final String MSG_SAVE_POSTQUERY = MessageUtil.getMsg("SAVE_QUERY");
    public static final String MSG_SAVE_RESPONSE = MessageUtil.getMsg("SAVE_RESPOSE");
    public static final String MSG_COPY_TENDER = MessageUtil.getMsg("COPY_TENDER");
    public static final String APP_CORRIGENGUM_MSG_PUBLISH = MessageUtil.getMsg("CORRIGENGUM_PUBLISH");
    public static final String NEGOTATION_IN_PROGRESS = MessageUtil.getMsg("NEGOTATION_IN_PROGRESS");
    public static final String SECURITY_BREACH =  MessageUtil.getMsg("SECURITY_BREACH");
}
