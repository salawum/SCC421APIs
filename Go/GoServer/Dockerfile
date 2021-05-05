FROM golang:latest AS build
WORKDIR /go/src
COPY go ./go
COPY main.go .
COPY .env /go/src/.env

ENV CGO_ENABLED=0
ENV GO111MODULE=on
RUN go get -d -v ./...

RUN go build -a -installsuffix cgo -o swagger .

FROM scratch AS runtime
COPY --from=build /go/src/swagger ./
COPY .env /go/src/.env

EXPOSE 8080/tcp
ENTRYPOINT ["./swagger"]
CMD ["go", "run", "main.go"]