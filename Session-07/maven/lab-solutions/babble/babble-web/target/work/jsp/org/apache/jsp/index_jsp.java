package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.sonatype.training.babble.services.BabbleManager;
import com.sonatype.training.babble.domain.Babbler;
import com.sonatype.training.babble.domain.Babble;
import java.util.List;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_f_message_key_nobody;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_f_message_key_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_f_message_key_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write(" \n");
      out.write("\n");

//
// In a real application, this would go in a controller
//
String user = request.getParameter("username");
Babbler babbler = (Babbler) session.getAttribute("babbler");

String action = request.getParameter("action");
if ("logout".equals(action)) {
    session.removeAttribute("babbler");
    babbler = null;
}

if ("login".equals(action)) {
	if ((user != null) && (user.trim().length() > 0)) {
		//
		// Logging on or registering
		//
		
		babbler = BabbleManager.getInstance().findByName(user);
		if (babbler == null) {
			babbler = BabbleManager.getInstance().register(user);
		}
		session.setAttribute("babbler",babbler);
	} 
}

if ("babble".equals(action)) {
	String message = request.getParameter("message");
	if ((message != null) && (message.trim().length() > 0) && (babbler != null)) {
	    babbler.utterBabble(message);   
	}
}

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<body>\n");
      out.write("<h2>");
      if (_jspx_meth_f_message_0(_jspx_page_context))
        return;
      out.write("</h2>\n");
      out.write("<p><em>Version ");
      if (_jspx_meth_f_message_1(_jspx_page_context))
        return;
      out.write("</em></p>\n");
      out.write("\n");
 
if (babbler == null) {

      out.write("\n");
      out.write("<h3>");
      if (_jspx_meth_f_message_2(_jspx_page_context))
        return;
      out.write("</h3>\n");
      out.write("<form method=\"get\">\n");
      out.write("  <table border=\"0\">\n");
      out.write("    <tr>\n");
      out.write("      <td>What's your username?</td>\n");
      out.write("      <td><input name=\"username\" type=\"text\"></td>\n");
      out.write("      <td>&nbsp;</td><td><input name=\"action\" value=\"login\" type=\"submit\"></td>\n");
      out.write("    </tr>\n");
      out.write("  </table>\n");
      out.write("</form>\n");

} else {

      out.write("\n");
      out.write("\n");
      out.write("<h3>Hi ");
      out.print(babbler.getName());
      out.write('!');
      out.write(' ');
      if (_jspx_meth_f_message_3(_jspx_page_context))
        return;
      out.write("</h3>\n");
      out.write("\n");
      out.write("<form method=\"get\">\n");
      out.write("  <table border=\"0\">\n");
      out.write("    <tr>\n");
      out.write("      <td>Message</td><td><input name=\"message\" type=\"text\"></td>\n");
      out.write("    </tr>\n");
      out.write("    <tr>\n");
      out.write("      <td>&nbsp;</td><td><input name=\"action\" type=\"submit\" value=\"babble\"></td>\n");
      out.write("    </tr>\n");
      out.write("  </table>\n");
      out.write("</form>\n");
      out.write("<form method=\"get\">\n");
      out.write("    <input name=\"action\" type=\"submit\" value=\"logout\">\n");
      out.write("</form>\n");
      out.write("\n");

} 

      out.write("\n");
      out.write("<h3>");
      if (_jspx_meth_f_message_4(_jspx_page_context))
        return;
      out.write("</h3>\n");
      out.write("\n");
      out.write("        <hr>\n");

      List<Babble> babbles = BabbleManager.getInstance().findAllBabbles();
      for (Babble babble : babbles) { 

      out.write("\n");
      out.write("        <p><b>");
      out.print(babble.getBabbler().getName());
      out.write("</b>: ");
      out.print(babble.getUtterence());
      out.write("</p>       \n");
      out.write("        <hr>\n");
 
      }

      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_f_message_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  f:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_f_message_0 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_f_message_key_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_f_message_0.setPageContext(_jspx_page_context);
    _jspx_th_f_message_0.setParent(null);
    _jspx_th_f_message_0.setKey("app.title");
    int _jspx_eval_f_message_0 = _jspx_th_f_message_0.doStartTag();
    if (_jspx_th_f_message_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_f_message_key_nobody.reuse(_jspx_th_f_message_0);
      return true;
    }
    _jspx_tagPool_f_message_key_nobody.reuse(_jspx_th_f_message_0);
    return false;
  }

  private boolean _jspx_meth_f_message_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  f:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_f_message_1 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_f_message_key_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_f_message_1.setPageContext(_jspx_page_context);
    _jspx_th_f_message_1.setParent(null);
    _jspx_th_f_message_1.setKey("app.version");
    int _jspx_eval_f_message_1 = _jspx_th_f_message_1.doStartTag();
    if (_jspx_th_f_message_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_f_message_key_nobody.reuse(_jspx_th_f_message_1);
      return true;
    }
    _jspx_tagPool_f_message_key_nobody.reuse(_jspx_th_f_message_1);
    return false;
  }

  private boolean _jspx_meth_f_message_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  f:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_f_message_2 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_f_message_key_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_f_message_2.setPageContext(_jspx_page_context);
    _jspx_th_f_message_2.setParent(null);
    _jspx_th_f_message_2.setKey("app.login");
    int _jspx_eval_f_message_2 = _jspx_th_f_message_2.doStartTag();
    if (_jspx_th_f_message_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_f_message_key_nobody.reuse(_jspx_th_f_message_2);
      return true;
    }
    _jspx_tagPool_f_message_key_nobody.reuse(_jspx_th_f_message_2);
    return false;
  }

  private boolean _jspx_meth_f_message_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  f:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_f_message_3 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_f_message_key_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_f_message_3.setPageContext(_jspx_page_context);
    _jspx_th_f_message_3.setParent(null);
    _jspx_th_f_message_3.setKey("app.utter.babble");
    int _jspx_eval_f_message_3 = _jspx_th_f_message_3.doStartTag();
    if (_jspx_th_f_message_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_f_message_key_nobody.reuse(_jspx_th_f_message_3);
      return true;
    }
    _jspx_tagPool_f_message_key_nobody.reuse(_jspx_th_f_message_3);
    return false;
  }

  private boolean _jspx_meth_f_message_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  f:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_f_message_4 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_f_message_key_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_f_message_4.setPageContext(_jspx_page_context);
    _jspx_th_f_message_4.setParent(null);
    _jspx_th_f_message_4.setKey("app.latest.babbles");
    int _jspx_eval_f_message_4 = _jspx_th_f_message_4.doStartTag();
    if (_jspx_th_f_message_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_f_message_key_nobody.reuse(_jspx_th_f_message_4);
      return true;
    }
    _jspx_tagPool_f_message_key_nobody.reuse(_jspx_th_f_message_4);
    return false;
  }
}
