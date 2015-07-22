package resource.example;

import securities.Account;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.hibernate.HibernateSessionFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

/**
 * Created by liker on 10/07/2015 0010.
 * Group iTailor.hunters.neu.edu.cn
 */
@Path("/account")
public class AccountResource {
    @GET
//    http://localhost:8080/webapi/account?name=liker&pwd=12134
    public boolean valid(@QueryParam("name") final String name,@QueryParam("pwd") final String pwd){
        Session session = HibernateSessionFactory.getSession();
        Transaction trans = session.beginTransaction();
        Account account = new Account("liker","12134");
        session.persist(account);
        Query query = session.createQuery(" select d from Account as d ");
        List<Account> accountList = query.list();
        for (Account d : accountList) {
           if(d.getName().equals(name)){
               if (d.getPwd().equals(pwd)){
                   trans.commit();
                   session.close();
                   return true;
               }
           }
        }
        trans.commit();
        session.close();
        return false;
    }

//    @Path("/imageList")
//    @GET
//    public Response senImage(){
////        String[] images = {"hello.jpg","world.jpg"};
////        return images;
//    }
}
