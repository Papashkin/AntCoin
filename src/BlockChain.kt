import java.util.*

    fun main(args: Array<String>){
        var firstBlock = Block()
        val blockchain: LinkedList<Block> = LinkedList()
        blockchain.add(firstBlock)
        var previousBlock: Block = blockchain[0]
        val number_of_blocks = 20

        for (num: Int in 0..(number_of_blocks-1)){
            var nextBlock = previousBlock.nextBlock(previousBlock)
            blockchain.add(nextBlock)
            previousBlock = nextBlock
            println("Block " + nextBlock.index + " has been added to the blockchain!")
            println("Hash: " + nextBlock.hash + "\n")
        }
    }
