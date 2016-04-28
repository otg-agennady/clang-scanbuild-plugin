package jenkins.plugins.clangscanbuild;

import hudson.model.FreeStyleProject;

import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;

import com.gargoylesoftware.htmlunit.html.HtmlForm;

public class ClangScanBuildBuilderTest {
	@Rule
	public JenkinsRule j = new JenkinsRule();
	
	@Test
	public void testRoundTripConfiguration() throws Exception{
		
		FreeStyleProject p = j.createFreeStyleProject();
		
		ClangAnalyzerBuilder builderBefore = new ClangAnalyzerBuilder( "target", "sdk", "config",
				"installName", "projPath", "workspace", "scheme", "someargs", "somexcodeargs", "someoutputfoldername" );
		p.getBuildersList().add( builderBefore );

		HtmlForm form = j.createWebClient().getPage( p, "configure" ).getFormByName( "config" );
		j.submit( form );

		ClangAnalyzerBuilder builderAfter = p.getBuildersList().get( ClangAnalyzerBuilder.class );

		j.assertEqualBeans( builderBefore, builderAfter, "target,config,targetSdk,xcodeProjectSubPath,workspace,scheme,scanbuildargs,xcodebuildargs,outputFolderName" );
	}
	
}
