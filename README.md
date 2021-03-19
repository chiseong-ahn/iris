# 아이리스(iris)
- 꽃말 : 다채스럽고 신비스러움, 좋은 소식, 행운/행복.
- 프로젝트 의미 : 회사에 필요한 여러 서비스들을 통합/관리함으로써 아름답게(쉽고 빠르게) 일하는 행복한 업무환경을 만들자.

## 아키텍쳐
- jdk 11+
- springboot 2.x+
- jpa & hibernate & querydsl
- gradle
- h2
- firebase
- react
- jwt
- spring boot docs
- junit

### gradle project 구성
1. 이클립스 빌드도구 플러그인 추가
build.gradle 의 plugins 에 추가.
```
plugins {
	id 'eclipse'
}

```

1. 기존 이클립스 프로젝트 설정파일 삭제
```
# gradle cleanEclipseProject
```
1. 이클립스 관련 모든설정 파일 생성
```
# gradle eclipse
```
1. 애플리케이션 실행
```
# gradle bootRun
```


수수정수