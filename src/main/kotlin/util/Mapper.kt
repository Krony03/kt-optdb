package util

internal interface Mapper<in INPUT, out OUTPUT> {
    fun map(input: INPUT): OUTPUT
}