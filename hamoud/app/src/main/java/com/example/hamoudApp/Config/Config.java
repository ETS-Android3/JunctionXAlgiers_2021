package com.example.hamoudApp.Config;

public class Config {
    public static final String Base_URL = "https://hamoudserver.000webhostapp.com/"; //AppLoginPart
    public static final String UPD_URL = Base_URL+"API/upsdwsFetch.php";
    public static final String PROFILE_DATA_URL = Base_URL + "API/profiledata.php?email=";
    public static final String TASKS_DATA_URL = Base_URL + "API/tasksdata.php?datestart=";
    public static final String WAITING_TASKS_DATA_URL = Base_URL + "API/waittasksdata.php?datestart=";
    public static final String LIVE_TASKS_DATA_URL = Base_URL + "API/livetasksdata.php?datestart=";
    public static final String DONE_TASKS_DATA_URL = Base_URL + "API/donetasksdata.php?datestart=";
    public static final String WORKERS_ONETASK_URL = Base_URL + "API/detaildata.php?id_task=";
    public static final String WORKERS_LIST_URL = Base_URL + "API/getWorkersData.php";
    public static boolean session = false ;
    public static final String IMAGE_PATH = "path" ;
    public static final String KEY_MOBILE = "mobile";
    public static final String KEY_TEL = "tel";
    public static final String KEY_ZIP =  "zip";
    public static final String KEY_NAME =  "name";
    public static final String KEY_ADDRESS =  "address";
    public static final String KEY_EMAIL =  "emailperson";
    public static final String KEY_IDTASK =  "id_task";
    public static final String KEY_TITLE =  "title";
    public static final String KEY_MSG =  "message";
    public static final String KEY_DATE =  "date";
    public static final String KEY_TIME =  "time_in";
    public static final String KEY_VOCAL = "vocal";
    public static final String KEY_WORKER_NAME = "username";
    public static final String KEY_STATE = "status";
    public static final String KEY_ID_WORKER = "id_worker";
    public static final String KEY_PHONE = "phone" ;
    public static final String KEY_UP = "ups";
    public static final String KEY_DW= "dws";
    public static final String JSON_ARRAY = "result";
}
