# coding: utf-8

from __future__ import absolute_import

from flask import json
from six import BytesIO

from swagger_server.models.planet import Planet  # noqa: E501
from swagger_server.models.planet_list import PlanetList  # noqa: E501
from swagger_server.test import BaseTestCase


class TestPlanetsController(BaseTestCase):
    """PlanetsController integration test stubs"""

    def test_add_planet(self):
        """Test case for add_planet

        Add a planet to the database
        """
        body = Planet()
        response = self.client.open(
            '/planet',
            method='POST',
            data=json.dumps(body),
            content_type='application/json')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_delete_planet(self):
        """Test case for delete_planet

        Delete a planet from the database
        """
        response = self.client.open(
            '/planet/{name}'.format(name='name_example'),
            method='DELETE')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_get_planet(self):
        """Test case for get_planet

        Get a planet from the database
        """
        response = self.client.open(
            '/planet/{name}'.format(name='name_example'),
            method='GET')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_get_terrain(self):
        """Test case for get_terrain

        Get a list of planets with the specified terrain type
        """
        response = self.client.open(
            '/planet/terrain/{terrain}'.format(terrain='terrain_example'),
            method='GET')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_get_uninhabited(self):
        """Test case for get_uninhabited

        Get a list of planets that are uninhabited
        """
        response = self.client.open(
            '/planet/uninhabited',
            method='GET')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_update_planet(self):
        """Test case for update_planet

        Update an existing planet
        """
        body = Planet()
        response = self.client.open(
            '/planet',
            method='PUT',
            data=json.dumps(body),
            content_type='application/json')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))


if __name__ == '__main__':
    import unittest
    unittest.main()
