FROM python:latest

# RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

# COPY requirements.txt /usr/src/app/
COPY requirements.txt ./

RUN pip3 install --no-cache-dir -r requirements.txt

COPY . .

EXPOSE 8080

# ENTRYPOINT ["python3"]

CMD ["python3", "-m", "swagger_server"]
