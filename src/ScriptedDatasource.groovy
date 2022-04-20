import com.egis.DocumentModel
import com.egis.Repository
import com.egis.Session
import com.egis.kernel.Kernel
import com.egis.kernel.db.DbManager

Repository repo = Kernel.get(Repository.class)
DbManager db = Kernel.get(DbManager.class)

repo.callAsSystem({ Session session ->
    List<String> results = new ArrayList<>()
    session.queryData("SELECT * FROM 'System/Lookup/Banking Details'").each {
        results.add(['cluster' :it.cluster,'sub_cluster':it.sub_cluster,'division' :it.division, 'function' :it.function,
                     'sub_function' :it.sub_function, 'activity' :it.activity])

    }
    return results.unique().sort()

})


