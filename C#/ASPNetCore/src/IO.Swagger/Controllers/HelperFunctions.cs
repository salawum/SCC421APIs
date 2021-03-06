using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading.Tasks;

namespace IO.Swagger.Controllers {
    /// <summary>
    /// 
    /// </summary>
    public static class HelperFunctions {
        /// <summary>
        /// Handles errors from the controller
        /// </summary>
        /// <param name="ex">Message generated from the error</param>
        public static StatusCodeResult ErrorStatusCode(Exception ex) {
            Console.WriteLine("Error: " + ex.Message);
            foreach(DictionaryEntry item in ex.Data) {
                Console.WriteLine("{0}: {1}", item.Key, item.Value);
                if(item.Key.ToString().Equals("Server Error Code")) {
                    switch(item.Value.ToString()) {
                        case "1062":
                        case "1452":
                            return new StatusCodeResult(409);
                        case "1046":
                            return new StatusCodeResult(404);
                        default:
                            return new StatusCodeResult(400);
                    }
                }
            }
            return new StatusCodeResult(400);
        }

        /// <summary>
        /// 
        /// </summary>
        /// <returns>The connection string for the database</returns>
        public static string getConnString() {
            string connString =
                "Server=" + Environment.GetEnvironmentVariable("DB_HOST") + "," + Environment.GetEnvironmentVariable("DB_PORT") + ";" +
                "Database=" + Environment.GetEnvironmentVariable("DB_DATABASE") + ";" +
                "User ID=" + Environment.GetEnvironmentVariable("DB_USER") + ";" +
                "Password=" + Environment.GetEnvironmentVariable("DB_PWD") + ";default command timeout=120";
            return connString;
        }

        /// <summary>
        /// Reads data from the .env file
        /// </summary>
        /// <param name="filePath">Path to the .env file</param>
        public static void Load(string filePath) {
            if(!File.Exists(filePath)) {
                Console.WriteLine("File doesn't exist: {0}", filePath);
                return;
            }

            Console.WriteLine(filePath);
            foreach(var line in File.ReadAllLines(filePath)) {
                var parts = line.Split('=', StringSplitOptions.RemoveEmptyEntries);

                if(parts.Length != 2) {
                    continue;
                }

                Environment.SetEnvironmentVariable(parts[0], parts[1]);
            }
        }
    }
}
