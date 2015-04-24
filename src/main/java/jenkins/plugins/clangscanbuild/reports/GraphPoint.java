package jenkins.plugins.clangscanbuild.reports;

import hudson.model.Run;

public class GraphPoint {

        private Run<?,?> run;


	private int bugCount;
	
	public GraphPoint(Run<?, ?> run, int bugCount) {
		super();
		this.run = run;
		this.bugCount = bugCount;
	}
	
	public Run<?, ?> getRun() {
		return run;
	}
	public void setRun(Run<?, ?> run) {
		this.run = run;
	}
	public int getBugCount() {
		return bugCount;
	}
	public void setBugCount(int bugCount) {
		this.bugCount = bugCount;
	}

}
