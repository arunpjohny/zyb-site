package in.co.zybotech.web.filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HeaderManipulationFilter implements Filter {
	private FilterConfig filterConfig = null;
	private Log log = LogFactory.getLog(HeaderManipulationFilter.class);

	public HeaderManipulationFilter() {

	}

	private void doBeforeProcessing(ServletRequest request,
			ServletResponse response) throws IOException, ServletException {
		if (log.isDebugEnabled()) {
			if (request instanceof HttpServletRequest) {
				HttpServletRequest req = (HttpServletRequest) request;
				log.debug("DoAfterProcessing for resource:"
						+ req.getRequestURI());
			}
		}

		HttpServletResponse res = (HttpServletResponse) response;
		for (@SuppressWarnings("unchecked")
		Enumeration<String> e = filterConfig.getInitParameterNames(); e
				.hasMoreElements();) {
			String headerName = (String) e.nextElement();
			res.addHeader(headerName, filterConfig.getInitParameter(headerName));
			if (log.isInfoEnabled()) {
				log.info(headerName + "="
						+ filterConfig.getInitParameter(headerName));
			}
		}
	}

	private void doAfterProcessing(ServletRequest request,
			ServletResponse response) throws IOException, ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		if (log.isDebugEnabled()) {
			log.debug("HeaderManipulationFilter:doFilter()");
		}

		doBeforeProcessing(request, response);

		Throwable problem = null;

		try {
			chain.doFilter(request, response);
		} catch (Throwable t) {
			problem = t;
			t.printStackTrace();
		}
		doAfterProcessing(request, response);

		if (problem != null) {
			log.error("Problem in Header Manipulation Filter: "
					+ problem.getMessage());
			if (problem instanceof ServletException)
				throw (ServletException) problem;
			if (problem instanceof IOException)
				throw (IOException) problem;
			sendProcessingError(problem, response);
		}
	}

	public FilterConfig getFilterConfig() {
		return (this.filterConfig);
	}

	public void setFilterConfig(FilterConfig filterConfig) {

		this.filterConfig = filterConfig;
	}

	public void destroy() {
	}

	public void init(FilterConfig filterConfig) {

		this.filterConfig = filterConfig;
		if (filterConfig != null) {
			if (log.isDebugEnabled()) {
				log.debug("HeaderManipulation:Initializing filter");
			}

		}
	}

	public String toString() {

		if (filterConfig == null)
			return ("HeaderManipulationFilter()");
		StringBuffer sb = new StringBuffer("HeaderManipulationFilter(");
		sb.append(filterConfig);
		sb.append(")");
		return (sb.toString());

	}

	private void sendProcessingError(Throwable t, ServletResponse response) {

		String stackTrace = getStackTrace(t);

		if (stackTrace != null && !stackTrace.equals("")) {

			try {

				response.setContentType("text/html");
				PrintStream ps = new PrintStream(response.getOutputStream());
				PrintWriter pw = new PrintWriter(ps);
				pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); // NOI18N

				// PENDING! Localize this for next official release
				pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
				pw.print(stackTrace);
				pw.print("</pre></body>\n</html>"); // NOI18N
				pw.close();
				ps.close();
				response.getOutputStream().close();
				;
			}

			catch (Exception ex) {
			}
		} else {
			try {
				PrintStream ps = new PrintStream(response.getOutputStream());
				t.printStackTrace(ps);
				ps.close();
				response.getOutputStream().close();
				;
			} catch (Exception ex) {
			}
		}
	}

	public static String getStackTrace(Throwable t) {

		String stackTrace = null;

		try {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			t.printStackTrace(pw);
			pw.close();
			sw.close();
			stackTrace = sw.getBuffer().toString();
		} catch (Exception ex) {
		}
		return stackTrace;
	}

}