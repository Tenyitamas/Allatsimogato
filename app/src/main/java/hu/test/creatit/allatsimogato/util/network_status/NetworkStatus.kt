package hu.test.creatit.allatsimogato.util.network_status

sealed class NetworkStatus {
    object Available: NetworkStatus()
    object Unavailable: NetworkStatus()
}
