package jenkins.plugins.clangscanbuild.publisher;

import hudson.model.FreeStyleProject;

import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;

import com.gargoylesoftware.htmlunit.html.HtmlForm;

public class ClangScanBuildPublisherTest {

	@Rule
	public JenkinsRule j = new JenkinsRule();

	@Test
	public void testRoundTripConfiguration() throws Exception{
		
		FreeStyleProject p = j.createFreeStyleProject();
		
		ClangScanBuildPublisher publisherBefore = new ClangScanBuildPublisher( true, 45, "Pods", "somereportfoldername");
		p.getPublishersList().add( publisherBefore );

		HtmlForm form = j.createWebClient().getPage( p, "configure" ).getFormByName( "config" );
		j.submit( form );

		ClangScanBuildPublisher publisherAfter = p.getPublishersList().get( ClangScanBuildPublisher.class );

		j.assertEqualBeans( publisherBefore, publisherAfter, "bugThreshold,markBuildUnstableWhenThresholdIsExceeded,clangexcludedpaths,reportFolderName" );
	}
	
}
