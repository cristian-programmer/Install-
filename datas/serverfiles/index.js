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


let conmysql= mysql_.createConnection(confimysql);
conmysql.connect(function(err){
  if(err){
    console.log(err);
  }

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
          //  console.log(resultset);
           conmysql.query("SELECT * FROM netx_bms_server.NETX_HISTORICAL_VALUE;", function(err, result){
            
              if(result.length >0 ){
                for(let i=0; i < result.length;i++ ){
                
             
                var DATE =new Date(result[i].DATE_);
                DATE.setTime(DATE);
                DATE_ = DATE.toLocaleString();
              //  console.log(DATE_);
                datamssql.push(DATE_);
                totaldate  = datamssql.length -1;
               
              }
           
              for(let i=0;i<resultset.length;i++){
                 
                var DATE =new Date(resultset[i].DATE);
                DATE.setTime(DATE);
                DATE = DATE.toLocaleString();
             
                  while(datamssql[totaldate] <= DATE){
                    for(let i=0; i < resultset.length;i++){
                      var DATE =new Date(resultset[i].DATE);
                      DATE.setTime(DATE);
                      DATE_ = DATE.toLocaleString();
    
                      var LOCAL_DATE = new Date(resultset[i].LOCAL_DATE);
                      LOCAL_DATE.setTime(LOCAL_DATE);
                      LOCAL_DATE_ = LOCAL_DATE.toLocaleString();
                      let insert="INSERT INTO netx_bms_server.NETX_HISTORICAL_VALUE (ID, HANDLE, VALUE_TYPE, NUM_VALUE, STR_VALUE, DATE_ , LOCAL_DATE, SOURCE_TYPE, SOURCE) VALUES ( '"+resultset[i].id+"', '"+resultset[i].HANDLE+"', '"+resultset[i].VALUE_TYPE+"', '"+resultset[i].NUM_VALUE+"', "+
                      " '"+resultset[i].STR_VALUE+"', '"+DATE_+"', '"+LOCAL_DATE_+"', '"+resultset[i].SOURCE_TYPE+"', '"+resultset[i].SOURCE+"');";
    
                            conmysql.query(insert, function(err, result){
                                    console.log(result);         
                                });
                     }

                  }
              }
            
              }else{
                for(let i=0; i < resultset.length;i++){
                  var DATE =new Date(resultset[i].DATE);
                  DATE.setTime(DATE);
                  DATE_ = DATE.toLocaleString();

                  var LOCAL_DATE = new Date(resultset[i].LOCAL_DATE);
                  LOCAL_DATE.setTime(LOCAL_DATE);
                  LOCAL_DATE_ = LOCAL_DATE.toLocaleString();
                  let insert="INSERT INTO netx_bms_server.NETX_HISTORICAL_VALUE (ID, HANDLE, VALUE_TYPE, NUM_VALUE, STR_VALUE, DATE_ , LOCAL_DATE, SOURCE_TYPE, SOURCE) VALUES ( '"+resultset[i].id+"', '"+resultset[i].HANDLE+"', '"+resultset[i].VALUE_TYPE+"', '"+resultset[i].NUM_VALUE+"', "+
                  " '"+resultset[i].STR_VALUE+"', '"+DATE_+"', '"+LOCAL_DATE_+"', '"+resultset[i].SOURCE_TYPE+"', '"+resultset[i].SOURCE+"');";

                        conmysql.query(insert, function(err, result){
                                console.log(result);         
                            });
                 }
               
              }
        

           });
      
        });
    });
});
}


setInterval(function(){
  console.log("--------------------");
  runScript();
},60000);

