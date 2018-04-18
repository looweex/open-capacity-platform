package com.open.capacity.srenewSer.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.jboss.logging.Param;

@Mapper
public interface AcceptTempDao {

 
	@Insert("INSERT INTO CRM_OWNER_USER.BB_ACCEPT_TEMP_T (F_TEMP_RGST_NO, F_CUST_ORDER_ID, F_BUNDLE_KIND, F_OPER_KIND, F_ACCEPT_CITY, "
			+ "F_ACCEPT_STATUS,F_CONTACT_ID, F_APPLY_EVENT,F_ACCEPT_PERSON, F_ACCEPT_ADDRESS_ID, "
			+ "F_ACCEPT_WAY, F_ACCEPT_DATE,F_SERVICE_KIND,F_SERVICE_ID, F_BATCH_FLAG, "
			+ "GROUP_PRODUCT, F_IF_ACCOUNT, F_BUNDLE_ID,F_UPDATE_NETWORK, STOP_MONTH, "
			+ "F_IF_GROUP_ACCEPT, F_O_DEVELOPERDEALER,F_ODEVELOPER) " + 
			"VALUES (#{OS_TEMP_RGST}, '24328582',0,0,  #{CITY_CODE}, "
			+ "0,4170324819906,302,#{oper_id}, #{channel_id}, "
			+ "1, TO_DATE (#{accept_date}, 'YYYYMMDDHH24MI'),#{service_kind},  #{service_id},0, " + "0,0, 0,0,0, "
			+ "0,'0', '0')")
	public int saveAcceptTemp(Map<String, Object> map);

	@Insert("INSERT INTO CRM_OWNER_USER.BB_WIDE_BUS_TEMP_T (REGISTER_NUMBER,ACCEPT_STATUS,  ACCEPT_CITY, APPLY_EVENT, ACCEPT_DATE,"
			+ "ACCEPT_PERSON,ACCEPT_ADDRESS_ID,  ACCEPT_WAY, APPLY_REASON, CITY_CODE,"
			+ "BUNDLE_ID,REGION_CODE, BELONG_CODE, USER_ID,CUSTOMER_ID,"
			+ "ACCOUNT_ID,  INHERIT_FLAG,  INHERIT_ID, SERVICE_ID,OPER_LEVEL,"
			+ "INNET_METHOD, DEALER_INNET_METHOD,CREDIT_SOLUTION, CREDIT_SOLU, IF_SELF_CONTROL,"
			+ "PASSWORD, SERV_CREDIT_CONTROL,PAY_TYPE,DEVELOPER_DEALER,DEVELOPER,"
			+ "SERVICE_FAVOUR_ID,SERVICE_GROUP_ID, SERVICE_IF_VALID,SER_SERVING_STATUS, ACCESS_LEVEL,"
			+ "BUS_FAVOUR_ID,PAY_WAY,INTELLIGENTIZE_FLAG, MONTH_FEE, IP_NUM,"
			+ "ACCESS_MAX_NUM,  IDLE_TIMEOUT, SESSION_TIMEOUT,  EXPIRATION_FLAG, EXPIRATION_DATE,"
			+ "TRUNKS_COUNT,INSTALL_ADDRESS, IF_SPAN_BUREAU,INSTALL_GROUP_ID, DATA_USER_LEVEL,"
			+ "AVAILABLE, IF_MSC, CONTRACT_TIME, RATE,NET_CIRCUIT,"
			+ "IF_INSTALL,  SCHOOL_ID, POS_FEE, MONEY_FEE,MONEY_WAY,"
			+ "MONTH_NUM,PC_BANK,INSTALL_KIND,BIND_SERVICE_KIND,  PRESENT_FEE,"
			+ "SOURCE_ID, IF_PRE_COOP,  IF_EMERGENCY,  IF_PRE_FEE, IF_DEPOSIT,"
			+ "IF_RESERVE, ACCEPT_SOURCE,  BRAND_ID,  VIA_ID_KIND,GRT_ID,"
			+ "GRT_IDENTITY_KIND,  GRT_DEPOSIT,GROUP_ID, USER_TYPE, SALES_MODE,"
			+ " APPLY_START_DATE,SERVICE_START_DATE,  DEALER_RETURN_DATE, DEALER_INPUT_DATE,STATUS_CHANGE_DATE,"
			+ "BRAND_ORG,SHARE_SCALE, NET_GRID)" +
			" VALUES ("
			+ "#{OS_TEMP_RGST}, 0, #{CITY_CODE}, 302,  TO_DATE (#{accept_date}, 'YYYYMMDDHH24MI'),"
			+ " #{oper_id},'4750684', 1, 0, #{CITY_CODE}," + " 0,   '75a17x',  '075750047',  #{USER_ID}, #{CUSTOMER_ID},"
			+ " #{ACCOUNT_ID}, 0, #{INHERIT_ID}, #{service_id},  #{service_kind}," 
			+ "#{innet_method}, -1, 0, 0, 0,"
			+ " #{PASSWORD}, 1, 4,'75b29gg','7505861677',"
			+ " #{SERVICE_FAVOUR_ID}, #{PAY_WAY}, 0,   0,  3,"
			+ " 0,0,  0,  0,  0,"
			+ " 0, 0,  0,  1, '2015-09-08',"
			+ " 1, #{REAL_INSTALL_ADDRESS}, 0,  '0',  0,"
			+ " 0,0,  0, '2',   0," + " 0,  0,   0,  0, 0,"
			+ " 0,  0,  0,   0,  0," + " '4750684',   0,  0, 0, 0,"
			+ "  0,0, '0', 0, 0," + " 1,  0,  '0',  0,   0,"
			+ " #{APPLY_START_DATE},  #{SERVICE_START_DATE}, #{DEALER_RETURN_DATE} , #{DEALER_INPUT_DATE} ,  #{STATUS_CHANGE_DATE} ,"
			+ " 0, 0,   #{NET_GRID})")
	public int saveWideTemp(Map<String, Object> map);

	@Insert("Insert into CRM_OWNER_USER.BB_BULK_SALE_BUS_TEMP_T(REGISTER_NUMBER, CITY_CODE, SERVICE_KIND, SERVICE_ID, USER_ID, "
			+ "BULK_PRICE, FAVOUR_GROUP, SALES_MODE, PERIOD_TYPE, EFFECT_VALUES, "
			+ "BEGIN_DATE, END_DATE) "
			+ "Values (#{OS_TEMP_RGST}, #{CITY_CODE}, #{service_kind}, #{service_id}, #{user_id}, "
			+ "544, 104, 84, 2, 36, "
			+ "#{END_DATE}, TO_DATE('01/01/2037 00:00:00', 'MM/DD/YYYY HH24:MI:SS'))")
	public int saveBulkTemp(Map<String, Object> map);
	
	public void getRegisterNumber(Map<String, Object> map) ;
	
	
	@Select("select bb_uni_get_info_detail_f(1,0,#{eparchy_code},#{service_id},'CBSS',2,'') serviceKind from dual")
	public Map getServiceKind(Map<String, Object> map);
	
	@Select("select * from bb_service_relation_t where service_kind = #{service_kind} and service_id=#{service_id} and city_code = #{eparchy_code} and if_valid=1 ")
	public Map getServiceInfo(Map<String, Object> map);
	
	@Select("  select * from bb_bulk_sale_info_t where service_id = #{service_id}  and service_kind =#{service_kind}  ")
	public Map getBulkInfo(Map<String, Object> map);

	
	@Select("     select * from bb_bus_control_t  where service_kind = #{service_kind} and service_id=#{service_id} and city_code = #{eparchy_code} ")
	public Map getFlowInfo(Map<String, Object> map);
	
	
	
			 
	@Select("   select * from bb_wide_service_info_t where user_id= #{user_id}")		 
	public Map getWidefo(Map<String, Object> map);
	
}