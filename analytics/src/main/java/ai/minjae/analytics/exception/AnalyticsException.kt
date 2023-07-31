package ai.minjae.analytics.exception

private const val NOT_INITIALIZED_EXCEPTION_MESSAGE = "[ADCIO Analytics] 초기화되지 않았습니다. (init 함수를 호출해 주세요.)"
private const val FILE_NOT_FOUND_EXCEPTION_MESSAGE = "[ADCIO Analytics] 파일을 찾을 수 없습니다."
private const val EMPTY_ENV_EXCEPTION_MESSAGE = "[ADCIO Analytics] 환경 변수가 입력되지 않았습니다."

class NotInitializedException : RuntimeException() {
    override val message: String
        get() = NOT_INITIALIZED_EXCEPTION_MESSAGE
}

//class FileNotFoundException : RuntimeException() {
//    override val message: String
//        get() = FILE_NOT_FOUND_EXCEPTION_MESSAGE
//}

class EmptyEnvFileException : RuntimeException() {
    override val message: String
        get() = EMPTY_ENV_EXCEPTION_MESSAGE
}
