import com.egis.data.node.Node
import com.egis.kernel.Kernel
import com.egis.kernel.db.DbManager

//Do not run as system
String parent = parent

if(parent == null){
    return []
}

DbManager db = Kernel.get(DbManager.class)
Node node = db.resolve(Node.class, parent)

if(node == null){
    return []
}

def children = []

node.children.each {Node child ->
    children.add(child.name)
}

return children