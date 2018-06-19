import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.util.*

class Block (var index: Int, var timestamp: String, var data: String, var previous_hash: String){
    var hash: String
     init {
         this.index = index
         this.timestamp = timestamp
         this.data = data
         this.previous_hash = previous_hash
         this.hash = getHashBlock(this.index,this.timestamp,this.data,this.previous_hash)
     }

    constructor() : this(0, Date().toString(), "This is block 0", "0")

    fun getHashBlock(index:Int, timestamp:String, data:String, previous_hash:String):String {
        var rec: String = (index.toString()) + timestamp + data + previous_hash
        var sha: MessageDigest = MessageDigest.getInstance("SHA-256")
        sha.update(rec.toByteArray(StandardCharsets.UTF_8))
        var hash:ByteArray = sha.digest()
        return Base64.getEncoder().encodeToString(hash)
    }

    fun nextBlock(lastBlock: Block) = Block(lastBlock.index+1, Date().toString(),
            "Hey! I'm block "+(lastBlock.index+1), lastBlock.hash)
 }