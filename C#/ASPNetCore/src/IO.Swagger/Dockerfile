FROM mcr.microsoft.com/dotnet/core/sdk:3.1 AS build-env
# WORKDIR /app
WORKDIR /usr/src/app

ENV DOTNET_CLI_TELEMETRY_OPTOUT 1

# copy csproj and restore as distinct layers
COPY *.csproj ./
RUN dotnet restore

# copy everything else and build
COPY . ./
COPY .env /usr/src/app/.env
RUN dotnet publish -c Release -o out

# build runtime image
FROM mcr.microsoft.com/dotnet/core/aspnet:3.1

WORKDIR /usr/src/app
COPY --from=build-env /usr/src/app/out .
COPY .env /usr/src/app/.env

EXPOSE 80
ENTRYPOINT ["dotnet", "IO.Swagger.dll"]
CMD ["run", "-p", "src/IO.Swagger/IO.Swagger.csproj", "--launch-profile", "web"]
