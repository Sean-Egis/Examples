import com.egis.DocumentModel
import com.egis.Session
import com.egis.SystemProcess
import com.egis.utils.Async
import com.egis.utils.Utils

Async.run(new SystemProcess() {
    @Override
    void execute(Session session) {
        Utils.sleep(2000)
        DocumentModel doc = session.getDocument(doc.docId)
        doc.allocate(doc.manager_name)
    }
})
