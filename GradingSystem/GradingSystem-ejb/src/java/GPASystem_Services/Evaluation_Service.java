package GPASystem_Services;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import pm.gradingsystem.entity.Evaluation;
import pm.gradingsystem.entity.Section;

/* @author Tahmasebi */
@Stateless
@LocalBean
public class Evaluation_Service {

    @PersistenceContext
    EntityManager em;

    public void saveMsg(Evaluation evaluation) {
        em.persist(evaluation);
    }

    public List<Evaluation> getFeedbacks(Section section) {
        TypedQuery<Evaluation> query = em.createQuery("SELECT e FROM Evaluation e WHERE e.section=:sec", Evaluation.class);

        return query.setParameter("sec", section).getResultList();
    }
}
