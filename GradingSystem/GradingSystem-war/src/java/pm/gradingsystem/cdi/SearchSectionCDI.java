/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.gradingsystem.cdi;

import GPASystem_Services.SectionService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import pm.gradingsystem.entity.Section;

@Named
@RequestScoped
public class SearchSectionCDI {
    private List<Section> sections = new ArrayList<>();
    private Section section;
    @EJB
    private SectionService sectionService;

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
    
    
    public SearchSectionCDI() {
    }
    
}
