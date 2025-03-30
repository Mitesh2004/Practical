<!-- 2. Create a JSP page for an online multiple choice test. The questions are randomly selected
from a database and displayed on the screen. The choices are displayed using radio
buttons. When the user clicks on next, the next question is displayed. When the user
clicks on submit, display the total score on the screen.-->

<!-- 1.Exam.jsp file-->

<%@page import="java.sql.*,java.util.*"%>
<%
    Class.forName("org.postgresql.Driver");
    Connection con = DriverManager.getConnection("jdbc:postgresql:amresh", "postgres", "8624807723");

    Set<Integer> s = new TreeSet<>();
    while (s.size() < 5) {
        int n = (int) (Math.random() * 11 + 1);
        s.add(n);
    }

    PreparedStatement ps = con.prepareStatement("select * from questions where qid=?");
%>

<form method='post' action='accept_ans.jsp'>
    <table width='70%' align='center'>
        <%
            int i = 0;
            Vector<Integer> v = new Vector<>(s);
            session.setAttribute("qids", v);

            int qid = v.get(i);
            ps.setInt(1, qid);
            ResultSet rs = ps.executeQuery();
            rs.next();
        %>
        <tr><td><b>Question:<%= i + 1 %></b></td></tr>
        <tr><td><pre><b><%= rs.getString(2) %></pre></b></td></tr>
        <tr><td>
            <b>
                <input type='radio' name='op' value=1 required><%= rs.getString(3) %><br>
                <input type='radio' name='op' value=2><%= rs.getString(4) %><br>
                <input type='radio' name='op' value=3><%= rs.getString(5) %><br>
                <input type='radio' name='op' value=4><%= rs.getString(6) %><br><br>
            </b>
        </td></tr>
        <tr>
            <td align='center'>
                <input type='submit' value='Next' name='ok'>
                <input type='submit' value='Submit' name='ok'>
            </td>
        </tr>
    </table>

    <input type='hidden' name='qno' value=<%= qid %>>
    <input type='hidden' name='qid' value=<%= i + 1 %>>
</form>


<!-- 2.Acceptans.jsp-->

<%@page import="java.sql.*,java.util.*"%>
<%
    Class.forName("org.postgresql.Driver");
    Connection con = DriverManager.getConnection("jdbc:postgresql:amresh", "postgres", "8624807723");

    Vector<String> answers = (Vector<String>) session.getAttribute("answers");
    if (answers == null) answers = new Vector<>();

    int qno = Integer.parseInt(request.getParameter("qno"));
    int ans = Integer.parseInt(request.getParameter("op"));
    int i = Integer.parseInt(request.getParameter("qid"));

    answers.add(qno + " " + ans);
    session.setAttribute("answers", answers);

    String ok = request.getParameter("ok");

    if (ok.equals("Submit") || i == 5) {
        response.sendRedirect("result.jsp");
        return;
    }

    PreparedStatement ps = con.prepareStatement("select * from questions where qid=?");
%>

<form method='post' action='accept_ans.jsp'>
    <table width='70%' align='center'>
        <%
            Vector<Integer> v = (Vector<Integer>) session.getAttribute("qids");
            int qid = v.get(i);
            ps.setInt(1, qid);
            ResultSet rs = ps.executeQuery();
            rs.next();
        %>
        <tr><td><b>Question:<%= i + 1 %></b></td></tr>
        <tr><td><pre><b><%= rs.getString(2) %></pre></b></td></tr>
        <tr><td>
            <b>
                <input type='radio' name='op' value=1 required><%= rs.getString(3) %><br>
                <input type='radio' name='op' value=2><%= rs.getString(4) %><br>
                <input type='radio' name='op' value=3><%= rs.getString(5) %><br>
                <input type='radio' name='op' value=4><%= rs.getString(6) %><br><br>
            </b>
        </td></tr>
        <tr>
            <td align='center'>
                <input type='submit' value='Next' name='ok'>
                <input type='submit' value='Submit' name='ok'>
            </td>
        </tr>
    </table>

    <input type='hidden' name='qno' value=<%= qid %>>
    <input type='hidden' name='qid' value=<%= i + 1 %>>
</form>


<!-- 3.Result.jsp-->

<%@page import="java.sql.*,java.util.*,java.text.*"%>
<%
    Class.forName("org.postgresql.Driver");
    Connection con = DriverManager.getConnection("jdbc:postgresql:amresh", "postgres", "8624807723");

    Vector<String> v = (Vector<String>) session.getAttribute("answers");
    if (v == null) {
%>
<h1>No questions answered</h1>
<%
        return;
    }

    PreparedStatement ps = con.prepareStatement("select ans from questions where qid=?");

    int totalScore = 0;

    for (String str : v) {
        int j = str.indexOf(' ');
        int qno = Integer.parseInt(str.substring(0, j));
        int userAns = Integer.parseInt(str.substring(j + 1));

        ps.setInt(1, qno);
        ResultSet rs = ps.executeQuery();
        rs.next();

        int correctAns = rs.getInt(1);

        if (userAns == correctAns) totalScore++;
    }

    session.invalidate(); // Clean up session data
%>
<h3>Score: <%= totalScore %> / 5</h3>
<center><a href='exam.jsp'>Restart Test</a></center>
