function fn() {
  var config = {
    baseUrl: 'http://localhost:8080'
  }

  karate.configure('connectTimeout', 5000)
  karate.configure('readTimeout', 5000)

  return config
}
