FROM golang:1.10 AS build
WORKDIR /go/src
COPY go ./go
COPY main.go .

ENV CGO_ENABLED=0
RUN go get -d -v ./...

RUN go build -a -installsuffix cgo -o swagger .

FROM scratch AS runtime
COPY --from=build /go/src/swagger ./
COPY .env /go/src/.env

EXPOSE 8080/tcp
ENTRYPOINT ["./swagger"]
RUN go get ./go
CMD ["go", "run", "main.go"]