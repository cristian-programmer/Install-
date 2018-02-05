var mssql = require("mssql");
const confi = require("./configdb");
var mysql_ = require("mysql");
const confi_ = require("./configdb");


const configmssql = {
    server:confi.mssql.server,
    database:confi.mssql.database,
    user:confi.mssql.user,
    password:confi.mssql.password,
    port: confi.mssql.port
};
const confimysql ={
    host:confi_.mysql.host,
    user:confi_.mysql.user,
    password:confi_.mysql.password,
    database:confi_.mysql.database
};

console.log(confimysql);

let conmysql= mysql_.createConnection(confimysql);
conmysql.connect(function(err){
  if(err){
    console.log(err);
  }

  console.log("OK!!.");
});


function ExceptionErrConect(err){
  console.log(err);
}


function ExceptionErrQuery(err){
  console.log(err);
}

function runScript(){
  return new Promise(function(resolve, reject){
    let datamssql=[];
    let con = new mssql.Connection(configmssql);
    let request = new mssql.Request(con);

    con.connect(function(err){
        if(err) throw ExceptionErrConect(err);
        console.log("Connection successfull");
        //"SELECT * FROM NETX_DEFINITION;"
        request.query("SELECT * FROM NETX_HISTORICAL_VALUE;", function(err, resultset){
          if(err) throw ExceptionErrQuery(err);
          // console.log(resultset);
          conmysql.query("CREATE DATABASE IF NOT EXISTS netx_bms_server", function(err, result){
            let Querytable = "CREATE TABLE IF NOT EXISTS netx_bms_server.NETX_HISTORICAL_VALUE (ID INT PRIMARY KEY, HANDLE INT, VALUE_TYPE INT, NUM_VALUE INT, STR_VALUE VARCHAR(30), DATE_ DATETIME , LOCAL_DATE DATETIME, SOURCE_TYPE INT, SOURCE VARCHAR(30));";
            conmysql.query(Querytable, function(err, result){
              let select ="SELECT * FROM netx_bms_server.NETX_HISTORICAL_VALUE";
              conmysql.query(select , function(err, result){  
          
                if(result.length === 0){

                  for(let i=0; i < resultset.length;i++){
                    var DATE =new Date(resultset[i].DATE);
                    DATE.setTime(DATE);
                    nw = DATE.toLocaleString();

                    var LOCAL_DATE = new Date(resultset[i].LOCAL_DATE);
                    LOCAL_DATE.setTime(LOCAL_DATE);
                    lnw = LOCAL_DATE.toLocaleString();
                    let insert="INSERT INTO netx_bms_server.NETX_HISTORICAL_VALUE ( ID, HANDLE, VALUE_TYPE, NUM_VALUE, STR_VALUE, DATE_ , LOCAL_DATE, SOURCE_TYPE, SOURCE) VALUES ('"+resultset[i].id+"','"+resultset[i].HANDLE+"', '"+resultset[i].VALUE_TYPE+"', '"+resultset[i].NUM_VALUE+"', "+
                    " '"+resultset[i].STR_VALUE+"', '"+nw+"', '"+lnw+"', '"+resultset[i].SOURCE_TYPE+"', '"+resultset[i].SOURCE+"');";

                          conmysql.query(insert, function(err, result){
                                  console.log("AQUI",result);         
                              });
                   }
                 }else{
                  let select ="SELECT * FROM netx_bms_server.NETX_HISTORICAL_VALUE";
                 conmysql.query(select, function(err, result){
                   console.log(result);
                   });
                   console.log("Hay Dato");

                   for(let i=0; i < resultset.length;i++){
                    var DATE =new Date(resultset[i].DATE);
                    DATE.setTime(DATE);
                    nw = DATE.toLocaleString();

                    var LOCAL_DATE = new Date(resultset[i].LOCAL_DATE);
                    LOCAL_DATE.setTime(LOCAL_DATE);
                    lnw = LOCAL_DATE.toLocaleString();
                    let insert="INSERT INTO netx_bms_server.NETX_HISTORICAL_VALUE (ID, HANDLE, VALUE_TYPE, NUM_VALUE, STR_VALUE, DATE_ , LOCAL_DATE, SOURCE_TYPE, SOURCE) VALUES ( '"+resultset[i].id+"', '"+resultset[i].HANDLE+"', '"+resultset[i].VALUE_TYPE+"', '"+resultset[i].NUM_VALUE+"', "+
                    " '"+resultset[i].STR_VALUE+"', '"+nw+"', '"+lnw+"', '"+resultset[i].SOURCE_TYPE+"', '"+resultset[i].SOURCE+"');";

                          conmysql.query(insert, function(err, result){
                                  console.log(result);         
                              });
                   }
                }
              });
            });
          });
        });
    });
});
}
  setInterval(function(){
    runScript();
  },10000);



