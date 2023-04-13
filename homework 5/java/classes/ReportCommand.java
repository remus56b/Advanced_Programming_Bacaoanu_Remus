package classes;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class ReportCommand implements Command {
    private Catalog catalog;
    private String path;

    public ReportCommand(Catalog catalog, String path) {
        this.catalog = catalog;
        this.path = path;
    }

    @Override
    public void ex() throws IOException {
        Configuration config = new Configuration(Configuration.VERSION_2_3_30);
        config.setClassForTemplateLoading(this.getClass(), "/templates");

        Map<String, Object> data = new HashMap<>();
        data.put("catalog", catalog);

        Template temp = config.getTemplate("app.html");

        File file = new File(path);
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));

        try {
            temp.process(data, writer);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

        // Open the report in the default system browser
        Desktop.getDesktop().browse(file.toURI());
    }
}
