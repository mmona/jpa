package com.kg.jbtsgl.commons;

import java.util.ArrayList;
import java.util.List;

public class Constance {
	public static final String TIMEZONE_DEFAULT = "US/Central";
	public static final String MM_DD_YY = "MM/dd/yy";
	public static final String MM_DD_YYYY = "MM/dd/yyyy";
	public static final Integer FLAG = 1;
	public static final String SENDER_NAME="QS CANS";
	public static final String NAME="CANSNY";
	
	/**
	 * when 1 :search the assessment which is create by current user
	 * when 2: search the assessment which is create by same level
	 */
	public static final String assessmentFlag = "1";
	
	/**
	 * 
	 *
	 */
	public static final String Asessment_List = "2";
	
	public static class EmailTemplete{
		public static final String DEAR="${USERNAME}";
		public static final String LINK="${LINK}";
		public static final String SEND_TIME="${EMAIL_SEND_TIME}";
		public static final String CIN="${CIN}";
		public static final String CREATE_TIME="${CREATE_TIME}";
	}
	
	public static class Session{
		public static final String SESSION_USER = "SessionUser";
		public static final String SESSION_USER_ROLES = "SessionUserRoles";
		public static final String SESSION_LIBRARY = "SessionLibrary";
		public static final String SESSION_CHILD_USERS = "SessionChildUsers";
		public static final String SESSION_PARENT_USERS = "SessionParentUsers";
		public static final String OLD_PARAMS = "OldParams";
		public static final String EXCEPTION = "Save System Exception";
		public static final String SERVICEFLAG = "serviceFlag";
	}

	public static class CustomizeSession{
		public static final String SESSION_STATE_QUESTION_RULE = "StateQuestionRule";
		public static final String SESSION_STATE_ALL_DOMAIN = "StateAllDomain";
		public static final String SESSION_STATE_ALL_QUESTION = "StateAllQuestion";
		public static final String SESSION_STATE_ALL_MODULE = "StateAllModule";
		public static final String SESSION_STATE_DOMAIN_RULE = "StateDomainRule";
		public static final String SESSION_DEFAULT_DOMAIN_RULE = "DefauleDomainRule";
		//public static final String SESSION_CUSTOMIZE = "OldParams";
	}
	public static class CaseStatus{
		public static final int NEW = 0;
		public static final int INCOMPLETE = 1;
		public static final int COMPLETED = 2;
	}
	public static class ForPrintCase{
		public static final int CHILD_STRENGTH_ID = 120;
		public static final int Suicide_Risk_C_SSRS_Screener = 121;
		public static final int OVERALL_SUICIDE_RISK  = 470;
	}
	
	public static List<String> requireCidPrivilege=new ArrayList<String>();
	
	static{
		requireCidPrivilege.add("Case_Add");
		requireCidPrivilege.add("Case_Edit");
	}
	public static class PageInfor{
		public static Integer DEFAULT_PAGESIZE = 20;
		public static Integer DEFAULT_CURRENTPAGE = 1;
	}
	
}
