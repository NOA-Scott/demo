//
//  FindViewController.swift
//  ElectronicsWallet
//
//  Created by NOA-Labs on 16/7/22.
//  Copyright © 2016年 NOA-Labs. All rights reserved.
//

import UIKit
import GoogleMaps


class FindViewController: UIViewController {

    
    @IBOutlet var mapView: MKMapView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // set initial location in Honolulu
        let camera = GMSCameraPosition.cameraWithLatitude(-33.868,
                                                          longitude:151.2086, zoom:6)
        let mapView = GMSMapView.mapWithFrame(CGRectZero, camera:camera)
        
        let marker = GMSMarker()
        marker.position = camera.target
        marker.snippet = "Hello World"
        marker.appearAnimation = kGMSMarkerAnimationPop
        marker.map = mapView
        
        self.view = mapView
        
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
}
