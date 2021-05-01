using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections;
using System.Collections.Generic;
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
                            Console.WriteLine("2");
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
                "Password=" + Environment.GetEnvironmentVariable("DB_PWD");
            return connString;
        }
    }
}
