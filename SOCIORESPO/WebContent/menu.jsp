
<% String userType = (String) session.getAttribute("USERTYPE"); 
	if(userType!=null && userType.equals("15002")){

%> 
 <div class="menu_bar">
      <ul>
        <!--<li><a href="/">Home</a></li>-->

        <li><a href="/PID/CommonPageAction.do?check=Profile">My Profile</a>
<!--        <input type="image"  onclick="profileLogin('Profile')"/>-->
          <ul>
<!--            <li><a><input type="image"  onclick="profileLogin('Profile')"/>My Profile</a></li>-->
<!--            <li><a><input type="image"  onclick="profileLogin('ManageEmp')"/>Manage Employees</a></li>-->
          </ul>
        </li>
        <li><a href="/PID/employeeAction.do?req=emp_List">
<!--        <input type="image"  onclick="profileLogin('ManageEmp')"/>-->
        Employee Details</a>
        <ul>
<!--            <li><a href="/HRApplyleave.jsp">Apply Leave</a></li>-->
<!--            <li><a href="HRRequestReport.jsp">Request Report</a></li>-->
        </ul>
        </li>
<li><a href="##">Reports</a>
       <ul>
            <li><a href="/PID/RequestReportAction.do?req=emp_Leave_List">Leave Report</a></li>
            <li><a  href="/PID/employeeAction.do?req=emp_report">Employee Report</a></li>
       </ul>
        </li>
        
      </ul>
      </div>
      
    <%
    }if(userType!=null && userType.equals("15001")){
    %>
    
        <div class="menu_bar">
      <ul>
        <!--<li><a href="/">Home</a></li>-->

        <li><a href="/PID/CommonPageAction.do?check=Profile" >My Profile</a>
          
        </li><!--
                <li><a href="/PID/employeeAction.do?req=emp_List">
        <input type="image"  onclick="profileLogin('ManageEmp')"/>
        Employee Details</a>
        <ul>
            <li><a href="/HRApplyleave.jsp">Apply Leave</a></li>
            <li><a href="HRRequestReport.jsp">Request Report</a></li>
        </ul>
        </li>
        
        --><li><a href="##">Leave Management</a>
        <ul>
            <li><a href="apply-leave.jsp">My Leave</a></li>
<!--	     <li><a href="SUP-screening-request.jsp">Team Leave Request</a><li>-->
            <li><a href="/PID/RequestReportAction.do?req=empReport">Leave Report</a></li>
	    
          </ul>
          </li>
<li><a href="/PID/taskMgntAction.do?req=task_List">Task Management</a></li>
	<!--	<li><a href="SUP-assigned-task.jsp">Task Report</a></li>  -->
           
      </ul>
      <span>      </span></div> 
    
    
    <%
    }if(userType!=null && userType.equals("15000")){
    %>
            <div class="menu_bar">
      <ul>
        <!--<li><a href="/">Home</a></li>-->

        <li><a href="/PID/CommonPageAction.do?check=Profile" >My Profile</a>
          
        
        <li><a href="apply-leave.jsp">My Leave</a>
          </li>
<li><a href="/PID/taskMgntAction.do?req=task_List">My Task</a></li>
	<!--	<li><a href="SUP-assigned-task.jsp">Task Report</a></li>  -->
           
      </ul>
      </div> 
      
    
      <%
    }
    %>
    
    