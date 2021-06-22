package helpers;

import FileManager.FileReaderManager;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ReportHelper {
    public static void generateCucumberReport() throws IOException {
        File reportOutputDirectory = new File("target");
        ArrayList<String> jsonFiles = new ArrayList<String>();
        jsonFiles.add("target/cucumber.json");
        Configuration configuration = new Configuration(reportOutputDirectory, "WalletHub");
        configuration.addClassifications("Project", "WalletHub");
        configuration.addClassifications("Platform", FileReaderManager.getInstance().getConfigReader().getPlatform());
        configuration.addClassifications("Browser", FileReaderManager.getInstance().getConfigReader().getBrowserName());
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}
