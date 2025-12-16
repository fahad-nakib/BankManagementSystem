/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class Query_SQL {
    Query_SQL()
    {
        Connect();
    }
    Connection con;
    PreparedStatement pst;
    ResultSet rs,rs2;
    Statement stmt;
    public void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject","root","");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Practice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public boolean previous_loan(String us_id)
    {
        boolean result = false;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT* FROM loan");
            while(rs.next())
            {
                String user_id = rs.getString("user_id");
                //int db_user_id = Integer.parseInt(user_id);
                //String password = rs.getString("admin_pass");
                if(us_id.equals(user_id)){
                    result = true;
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public void issue_loan(String user_id, String amount,String date){
        if(previous_loan(user_id))
        {
            //  UPDATE loan SET amount = amount+250 , issu_date ='12-5-23' WHERE user_id = 2002;
            try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE loan SET amount = amount+ ? , issu_date =? WHERE user_id = ?");            
            pstmt.setDouble(1,Double.parseDouble(amount));
            pstmt.setString(2,date);
            pstmt.setInt(3,Integer.parseInt(user_id));
            pstmt.executeUpdate();  
            
            } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO loan (user_id, amount, issu_date) VALUES (?,?,?)");            
            pstmt.setInt(1,Integer.parseInt(user_id));
            pstmt.setDouble(2,Double.parseDouble(amount));
            pstmt.setString(3,date);
            
            pstmt.executeUpdate();  
            
            } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public boolean verifie_user_id(String us_id,String b_id)
    {
        boolean result = false;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT* FROM user_table");
            while(rs.next())
            {
                String user_id = rs.getString("user_id");
                String branch_id = rs.getString("branch_id");
                //int db_user_id = Integer.parseInt(user_id);
                //String password = rs.getString("admin_pass");
                //result = us_id.equals(user_id)&& b_id.equals(branch_id);
                if(us_id.equals(user_id)&& b_id.equals(branch_id)){
                    result = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public void return_loan(String us_id, String amount)
    {
        try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE loan SET amount = amount- ? WHERE user_id = ?");            
            pstmt.setDouble(1,Double.parseDouble(amount));
            //pstmt.setString(2,date);
            pstmt.setInt(2,Integer.parseInt(us_id));
            pstmt.executeUpdate();  
            
            } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void insert_branch(String b_name, String b_location)
    {
        try {
            //stmt = con.createStatement();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO branch (branch_name, location) VALUES(?,?)");
            
            pstmt.setString(1,b_name);
            pstmt.setString(2,b_location);
            pstmt.executeUpdate();  
            
        } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String get_branch(String b_id)
    {
        String result= null;
        try {
            stmt = con.createStatement();
            PreparedStatement pstmt = con.prepareStatement("SELECT* FROM branch WHERE branch_id = ?");            
            pstmt.setInt(1,Integer.parseInt(b_id));
            //pstmt.setString(2,pwd);
            //pstmt.executeUpdate();
            rs2 = pstmt.executeQuery();

            if(rs2.next())
            {
                String b_name = rs2.getString("branch_name");
                result = b_name;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public String get_designation(String b_id)
    {
        String result= null;
        try {
            stmt = con.createStatement();
            PreparedStatement pstmt = con.prepareStatement("SELECT* FROM designation WHERE designation_id = ?");            
            pstmt.setInt(1,Integer.parseInt(b_id));
            //pstmt.setString(2,pwd);
            //pstmt.executeUpdate();
            rs2 = pstmt.executeQuery();

            if(rs2.next())
            {
                String b_name = rs2.getString("designation_name");
                result = b_name;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public int get_branch_id(String b_name)
    {
        int result= -1;
        try {
            stmt = con.createStatement();
            PreparedStatement pstmt = con.prepareStatement("SELECT* FROM branch WHERE branch_name = ?");            
            pstmt.setString(1,b_name);
            //pstmt.setString(2,pwd);
            //pstmt.executeUpdate();
            rs2 = pstmt.executeQuery();

            if(rs2.next())
            {
                String b_id = rs2.getString("branch_id");
                result = Integer.parseInt(b_id);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public int get_designation_id(String d_name)
    {
        int result= -1;
        try {
            stmt = con.createStatement();
            PreparedStatement pstmt = con.prepareStatement("SELECT* FROM designation WHERE designation_name = ?");            
            pstmt.setString(1,d_name);
            //pstmt.setString(2,pwd);
            //pstmt.executeUpdate();
            rs2 = pstmt.executeQuery();

            if(rs2.next())
            {
                String d_id = rs2.getString("designation_id");
                result = Integer.parseInt(d_id);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public String get_balance(String u_id)
    {
        String result= null;
        try {
            stmt = con.createStatement();
            PreparedStatement pstmt = con.prepareStatement("SELECT* FROM balance WHERE user_id = ?");            
            pstmt.setInt(1,Integer.parseInt(u_id));
            //pstmt.setString(2,pwd);
            //pstmt.executeUpdate();
            rs2 = pstmt.executeQuery();

            while(rs2.next())
            {
                String balance = rs2.getString("balance_amount");
                result = balance;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public boolean user_login(String u_id, String pwd)
    {
        boolean result = false;
        try {
            stmt = con.createStatement();
            //rs = stmt.executeQuery("SELECT* FROM practice");
            PreparedStatement pstmt = con.prepareStatement("SELECT* FROM user_table WHERE user_id = ? AND user_pass = ?");            
            pstmt.setInt(1,Integer.parseInt(u_id));
            pstmt.setString(2,pwd);
            //pstmt.executeUpdate();
            rs2 = pstmt.executeQuery();

            if(rs2.next())
            {
                result = true;
            }else{
                result =  false;
            }

            
        } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public void with_draw(double w_amount,String u_id)
    {
        try {
            stmt = con.createStatement();
            PreparedStatement pstmt = con.prepareStatement("SELECT* FROM balance WHERE user_id = ?");            
            pstmt.setInt(1,Integer.parseInt(u_id));
            //pstmt.setString(2,pwd);
            //pstmt.executeUpdate();
            rs2 = pstmt.executeQuery();

            while(rs2.next())
            {
                String balance = rs2.getString("balance_amount");
                double bale = Double.parseDouble(balance);
                double new_bal = bale - w_amount;
                
                PreparedStatement pstmt2 = con.prepareStatement("UPDATE balance SET balance_amount = ? WHERE user_id = ?");            
                pstmt2.setDouble(1,new_bal);
                pstmt2.setInt(2,Integer.parseInt(u_id));
                //pstmt.setString(2,pwd);
                //pstmt.executeUpdate();
                pstmt2.executeUpdate();
                //UPDATE `balance` SET `user_id`='[value-1]',`balance_amount`='[value-2]' WHERE 1
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String register_user(String u_name,String address,String phone,String email,String age,String password,int b_id)
    {
        String result = null;
        try {
            //stmt = con.createStatement();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO user_table (user_name,address,phone,email,age,user_pass,branch_id) VALUES(?,?,?,?,?,?,?)");
            
            pstmt.setString(1,u_name);
            pstmt.setString(2,address);
            pstmt.setInt(3,Integer.parseInt(phone));
            pstmt.setString(4,email);
            pstmt.setInt(5,Integer.parseInt(age));
            pstmt.setString(6,password);
            pstmt.setInt(7,b_id);
            pstmt.executeUpdate();  
            // SELECT AUTO_INCREMENT FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'DatabaseName' AND   TABLE_NAME   = 'TableName';
            PreparedStatement pstmt2 = con.prepareStatement("SELECT AUTO_INCREMENT FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'myproject' AND   TABLE_NAME   = 'user_table';");
            rs2 = pstmt2.executeQuery();
            while(rs2.next())
            {
                String Us_id = String.valueOf(rs2.getInt(1));
                int usr_id = Integer.parseInt(Us_id) - 1;
                String us_id = String.valueOf(usr_id);
                balance_insart(us_id,"0");
                result = us_id;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public void balance_insart(String us_id , String amount)
    {
        try {
            //stmt = con.createStatement();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO balance (user_id, balance_amount) VALUES(?,?)");
            
            pstmt.setInt(1,Integer.parseInt(us_id));
            pstmt.setDouble(2,Double.parseDouble(amount));
            pstmt.executeUpdate();  
            
        } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void register_employee(String userName,String address,String phone,String email,String password, String gender, int designation,int branch,String join_date,String age)
    {
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO employee (employee_name, address, phone, email, age, emp_pass, joining_date, gender, designation_id, branch_id) VALUES(?,?,?,?,?,?,?,?,?,?)");
            
            pstmt.setString(1,userName);
            pstmt.setString(2,address);
            pstmt.setInt(3,Integer.parseInt(phone));
            pstmt.setString(4,email);
            pstmt.setInt(5,Integer.parseInt(age));
            pstmt.setString(6,password);
            pstmt.setString(7,join_date);
            pstmt.setString(8,gender);
            pstmt.setInt(9,designation);
            pstmt.setInt(10,branch);
            pstmt.executeUpdate();  
            
        } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void update_employee(String userName,String address,String phone,String email,String password, String designation,String branch,String age,String user_id){
        try {
            //stmt = con.createStatement();
            PreparedStatement pstmt = con.prepareStatement("UPDATE employee SET employee_name = ? , address = ? , phone = ? , email = ?, age = ?, emp_pass = ?, designation_id = ?,branch_id = ? WHERE employee_id = ?");
            
            int designation_id = get_designation_id(designation);
            int branch_id = get_branch_id(branch);
            pstmt.setString(1,userName);
            pstmt.setString(2,address);
            pstmt.setInt(3,Integer.parseInt(phone));
            pstmt.setString(4,email);
            pstmt.setInt(5,Integer.parseInt(age));
            pstmt.setString(6,password);
            pstmt.setInt(7,designation_id);
            pstmt.setInt(8,branch_id);
            pstmt.setInt(9,Integer.parseInt(user_id));
            pstmt.executeUpdate();   
            
        } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    // update_employee_man
    
    public void update_employee_man(String userName,String address,String phone,String email,String password,String branch,String age,String user_id){
        try {
            //stmt = con.createStatement();
            PreparedStatement pstmt = con.prepareStatement("UPDATE employee SET employee_name = ? , address = ? , phone = ? , email = ?, age = ?, emp_pass = ? WHERE branch_id = ? AND employee_id = ?");
            
            //int designation_id = get_designation_id(designation);
            //int branch_id = get_branch_id(branch);
            pstmt.setString(1,userName);
            pstmt.setString(2,address);
            pstmt.setInt(3,Integer.parseInt(phone));
            pstmt.setString(4,email);
            pstmt.setInt(5,Integer.parseInt(age));
            pstmt.setString(6,password);
            //pstmt.setInt(7,designation_id);
            pstmt.setInt(7,Integer.parseInt(branch));
            pstmt.setInt(8,Integer.parseInt(user_id));
            pstmt.executeUpdate();   
            
        } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void promotion_employee_man(String user_id,String d_name,String b_id){
        try {
            //stmt = con.createStatement();
            PreparedStatement pstmt = con.prepareStatement("UPDATE employee SET desigantion_id = ? WHERE branch_id = ? AND employee_id = ?");
            
            int designation_id = get_designation_id(d_name);
            //int branch_id = get_branch_id(b_id);
            pstmt.setInt(1,designation_id);
            pstmt.setInt(2,Integer.parseInt(b_id));
            pstmt.setInt(3,Integer.parseInt(user_id));
            pstmt.executeUpdate();   
            
        } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    // "DELETE FROM branch WHERE `branch`.`branch_id` = 304"?
    
    public void del_branch(String b_name)
    {
        
        try {
            int b_id = get_branch_id(b_name);
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM branch WHERE branch.branch_id = ?");            
            pstmt.setInt(1,b_id);
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void del_emp(String e_id,String e_name)
    {      
        try {
            
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM employee WHERE employee.employee_id = ?");            
            pstmt.setInt(1,Integer.parseInt(e_id));
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //set_salary
    public void set_salary(String d_name,String amount)
    {
        
        try {
            int d_id = get_designation_id(d_name);
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO salary(designation_id, salary_amount) VALUES (?,?)");            
            pstmt.setInt(1,d_id);
            pstmt.setDouble(2,Double.parseDouble(amount));
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void update_salary(String d_name,String amount)
    {
        
        try {
            int d_id = get_designation_id(d_name);
            PreparedStatement pstmt = con.prepareStatement("UPDATE salary SET salary_amount = ? WHERE designation_id = ?");            
            pstmt.setDouble(1,Double.parseDouble(amount));
            pstmt.setInt(2,d_id);
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String emp_count(int b_id)
    {
        String result= null;
        try {
            stmt = con.createStatement();
            PreparedStatement pstmt = con.prepareStatement("SELECT COUNT(DISTINCT employee_id) FROM employee WHERE branch_id = ?");            
            pstmt.setInt(1,b_id);
            rs2 = pstmt.executeQuery();
            while(rs2.next())
            {
                //String no_emp = rs2.getString("employee_id");
                //String no_emp = String.valueOf(rs2.getInt(1));
                String no_emp = String.valueOf(rs2.getInt(1));
                result = no_emp;
                //jTextArea2.setText(no_emp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return result;
    }
    //usr_count
    public String usr_count(int b_id)
    {
        String result= null;
        try {
            stmt = con.createStatement();
            PreparedStatement pstmt = con.prepareStatement("SELECT COUNT(DISTINCT user_id) FROM user_table WHERE branch_id = ?");            
            pstmt.setInt(1,b_id);
            rs2 = pstmt.executeQuery();
            while(rs2.next())
            {
                //String no_emp = rs2.getString("employee_id");
                //String no_emp = String.valueOf(rs2.getInt(1));
                String no_usr = String.valueOf(rs2.getInt(1));
                result = no_usr;
                //jTextArea2.setText(no_emp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return result;
    }
    public String br_loan_sum(int b_id)
    {
        String result= null;
        try {
            stmt = con.createStatement();
            PreparedStatement pstmt = con.prepareStatement("SELECT SUM(amount) FROM loan,user_table WHERE loan.user_id = user_table.user_id AND branch_id = ?");            
            pstmt.setInt(1,b_id);
            rs2 = pstmt.executeQuery();
            while(rs2.next())
            {
                //String no_emp = rs2.getString("employee_id");
                //String no_emp = String.valueOf(rs2.getInt(1));
                String tot_sum = String.valueOf(rs2.getInt(1));
                result = tot_sum;
                //jTextArea2.setText(no_emp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return result;
    }
    public void update_user_info(String u_name, String address, String phone, String email, String age,String u_id){
        
        try {
            //stmt = con.createStatement();
            PreparedStatement pstmt = con.prepareStatement("UPDATE user_table SET user_name = ?, address = ? , phone = ?, email = ? , age = ? WHERE user_id = ?;");
            
            //int designation_id = get_designation_id(designation);
            //int branch_id = get_branch_id(branch);
            pstmt.setString(1,u_name);
            pstmt.setString(2,address);
            pstmt.setInt(3,Integer.parseInt(phone));
            pstmt.setString(4,email);
            pstmt.setInt(5,Integer.parseInt(age));
            pstmt.setInt(6,Integer.parseInt(u_id));
            pstmt.executeUpdate();   
            
        } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean veriry_user_info(String us_id, String u_pass)
    {
        boolean result = false;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT* FROM user_table");
            while(rs.next())
            {
                String user_id = rs.getString("user_id");
                String user_pass = rs.getString("user_pass");
                if(us_id.equals(user_id)&& u_pass.equals(user_pass)){
                    result = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public void update_balance(String us_id , String amount)
    {
        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("UPDATE balance SET balance_amount = balance_amount + ? WHERE user_id = ?");
            pstmt.setDouble(1,Double.parseDouble(amount));
            pstmt.setInt(2,Integer.parseInt(us_id));
            pstmt.executeUpdate();   
            
        } catch (SQLException ex) {
            Logger.getLogger(Query_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean verifie_employee(String em_id, String em_pss, String em_d_id,String em_br_id)
    {
        boolean result = false;
        try {
            //stmt = con.createStatement();            
            //rs = stmt.executeQuery("SELECT employee_id, emp_pass, branch_id,designation_id FROM employee");
            //rs = stmt.executeQuery("SELECT *FROM employee WHERE employee_id = ?");
            //stmt.setInt(1,Integer.parseInt(em_id));
            
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("SELECT* FROM employee WHERE employee_id = ?");
            //pstmt.setDouble(1,Double.parseDouble(amount));
            pstmt.setInt(1,Integer.parseInt(em_id));
            rs = pstmt.executeQuery();   
            
            while(rs.next())
            {
                String db_emp_id = rs.getString("employee_id");
                //int db_user_id = Integer.parseInt(user_id);
                String db_password = rs.getString("emp_pass");
                String db_branch_id = rs.getString("branch_id");
                String db_designation_id = rs.getString("designation_id");
                if( em_id.equals(db_emp_id) && em_pss.equals(db_password) && em_br_id.equals(db_branch_id) && em_d_id.equals(db_designation_id)) result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public boolean verifie_administarator(String user_ID,String pwd)
    {
        boolean result = false;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT* FROM administrator");
            while(rs.next())
            {
                String admin_id = rs.getString("admin_id");
                //int db_user_id = Integer.parseInt(user_id);
                String admin_pass = rs.getString("admin_pass");
                if(user_ID.equals(admin_id) && pwd.equals(admin_pass))                
                {
                    result = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public void us_comment(String comment, String us_id)
    {
        try {
           
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO feedback(user_id, oppinion) VALUES (?,?)");            
            pstmt.setInt(1,Integer.parseInt(us_id));
            pstmt.setString(2,comment);
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean delet_user(String us_id,String b_id){
        boolean result = true;
        try {
            
            PreparedStatement pstmt = con.prepareStatement("DELETE user_table,balance FROM user_table INNER JOIN balance \n" +
            "WHERE user_table.user_id = balance.user_id AND user_table.user_id = ? AND user_table.branch_id = ?\n");            
            pstmt.setInt(1,Integer.parseInt(us_id));
            pstmt.setInt(2,Integer.parseInt(b_id));
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            result = false;
            Logger.getLogger(AdmimLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
/*
SELECT SUM(amount) FROM loan,user_table WHERE loan.user_id = user_table.user_id AND branch_id = 300;

*/
