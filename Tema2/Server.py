import json
from http.server import HTTPServer, BaseHTTPRequestHandler


class RequestHandler(BaseHTTPRequestHandler):
    def do_GET(self):
        data = {}
        resourceFile = open('resources.json', 'r')
        resources = json.loads(resourceFile.read())

        if (self.path == '/anotherResource'):
            data['data'] = resources['RESOURCE_2']
        elif (self.path == '/'):
            data['data'] = resources['RESOURCE_1']

        self.send_response(200)
        self.end_headers()

        self.wfile.write(json.dumps(data).encode('utf-8'))
        resourceFile.close()
        return

    def do_POST(self):
        requestBodyLength = (lambda x: x[1] == 'content-length', self.headers._headers[7])[1][1]
        requestBody = self.rfile.read(int(requestBodyLength))
        jsonRequestBody = json.loads(requestBody)

        resourceFile = open('resources.json', 'r+')

        resources = json.loads(resourceFile.read())

        try:
             if (self.path == '/anotherResource'):
                 resources['RESOURCE_2'].append(jsonRequestBody['data'])
             elif (self.path == '/'):
                 resources['RESOURCE_1'].append(jsonRequestBody['data'])
        except Exception:
            self.send_response(400)
            self.end_headers()
            return


        self.send_response(201)
        self.end_headers()

        resourceFile.seek(0)
        resourceFile.truncate()
        resourceFile.write(str(resources).replace('\'', '\"'))
        resourceFile.close()
        return

    def do_PUT(self):
        requestBodyLength = (lambda x: x[1] == 'content-length', self.headers._headers[7])[1][1]
        requestBody = self.rfile.read(int(requestBodyLength))
        jsonRequestBody = json.loads(requestBody)

        resourceFile = open('resources.json', 'r+')

        resources = json.loads(resourceFile.read())

        elementNumber = int(jsonRequestBody['elementNumber'])

        try:
             if (self.path == '/anotherResource'):
                 resources['RESOURCE_2'][elementNumber-1] = jsonRequestBody['data']
             elif (self.path == '/'):
                 resources['RESOURCE_1'][elementNumber-1] = jsonRequestBody['data']
        except Exception:
            self.send_response(204)
            self.end_headers()
            return


        self.send_response(200)
        self.end_headers()

        resourceFile.seek(0)
        resourceFile.truncate()
        resourceFile.write(str(resources).replace('\'', '\"'))
        resourceFile.close()
        return

    def do_DELETE(self):
        requestBodyLength = (lambda x: x[1] == 'content-length', self.headers._headers[7])[1][1]
        requestBody = self.rfile.read(int(requestBodyLength))
        jsonRequestBody = json.loads(requestBody)

        resourceFile = open('resources.json', 'r+')

        resources = json.loads(resourceFile.read())

        elementNumber = int(jsonRequestBody['elementNumber'])

        try:
             if (self.path == '/anotherResource'):
                 resources['RESOURCE_2'].pop(elementNumber-1)
             elif (self.path == '/'):
                 resources['RESOURCE_1'].pop(elementNumber-1)
        except Exception:
            self.send_response(204)
            self.end_headers()
            return


        self.send_response(200)
        self.end_headers()

        resourceFile.seek(0)
        resourceFile.truncate()
        resourceFile.write(str(resources).replace('\'', '\"'))
        resourceFile.close()
        return


httpd = HTTPServer(('127.0.0.1', 8090), RequestHandler)
print("SERVER STARTED ON PORT: 8090..")

while True:
    httpd.handle_request()
