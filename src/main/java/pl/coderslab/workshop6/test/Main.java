package pl.coderslab.workshop6.test;

import org.apache.commons.lang3.StringUtils;
import pl.coderslab.workshop6.entity.Project;

public class Main {

    public static void main(String[] args) {

        Project project = new Project();
        project.setName("bąk 3 ból");

        project.setProjectId(StringUtils.stripAccents(project.getName()).replaceAll("\\s+","-"));

        System.out.println(project.getProjectId());

    }


}
