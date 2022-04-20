import com.egis.Repository
import com.egis.Session
import com.egis.kernel.Kernel
import com.egis.utils.Is
import com.egis.utils.Utils

Kernel.get(Repository.class).callAsSystem({Session session->
    session.query("SELECT * FROM 'Lewis Group/EHS/Inspection Forms/Action Tracker' WHERE recursive=true").each {
        if (!Is.empty(it.question_number) && !it.question_number.contains('.')) {
            Double val = Utils.parseDouble(it.question_number)
            it.question_number_old = it.question_number
            it.question_number = val.toString()
            it.save()
        }
    }
})
